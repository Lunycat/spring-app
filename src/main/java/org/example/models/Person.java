package org.example.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
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

    private Long id;
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 chartres")
    private String name;

    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 chartres")
    private String surname;

    @Min(value = 1, message = "Age should be min 1 year old")
    private Integer age;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Address should be in this format: Country, City, Postal Code (6 digits)")
    private String address;
}
