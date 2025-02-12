package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dao.PersonDao;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDao personDao;

    @Autowired
    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("person", personDao.show(id));
        return "people/show";
    }

    //Create new Person----------------------------
    @GetMapping("/new")
    public String form(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDao.save(person);
        return "redirect:/people";
    }
    //---------------------------------------------

    //Update new Person----------------------------
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", personDao.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String patch(@PathVariable("id") Long id, @ModelAttribute("person") @Valid Person person,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDao.update(id, person);
        return "redirect:/people/" + id;
    }
    //---------------------------------------------

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        personDao.delete(id);
        return "redirect:/people";
    }
}
