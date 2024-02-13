package com.rrh.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres")
    private String name;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Size(min = 2, max = 20, message = "El apellido debe tener entre 2 y 20 caracteres")
    private String lastname;

    @NotNull(message = "El nombre de la compañía no puede ser nulo")
    @NotBlank(message = "El nombre de la compañía no puede estar en blanco")
    private String company;
    @OneToMany
    private List<Job_vacancy> jobVacancies;
}
