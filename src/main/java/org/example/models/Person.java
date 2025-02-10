package org.example.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 chartres")
    private String name;

    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 chartres")
    private String surname;

    @Email(message = "Email should be valid")
    private String email;
}
