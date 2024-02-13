package com.rrh.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job_vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "El título no puede ser nulo")
    @NotBlank(message = "El título no puede estar en blanco")
    private String title;

    @NotNull(message = "La modalidad de trabajo no puede ser nula")
    @NotBlank(message = "La modalidad de trabajo no puede estar en blanco")
    private String work_modality;

    @NotEmpty(message = "La lista de tecnologías no puede estar vacía")
    private List<String> technologies;

    @Size(max = 1000, message = "Los requisitos deben tener como máximo 1000 caracteres")
    private String requirements;

    @Min(value = 0, message = "El número de solicitantes de América Latina debe ser al menos 0")
    private int latam_applicants;

    @Min(value = 0, message = "El número de solicitantes de EE. UU. debe ser al menos 0")
    private int usa_applicants;

    @Min(value = 0, message = "El número de solicitantes de Europa debe ser al menos 0")
    private int europe_applicants;

    @Min(value = 0, message = "El número de solicitantes de Asia debe ser al menos 0")
    private int asia_applicants;

    @Min(value = 1, message = "Debe haber al menos 1 aplicante")
    private int number_applicants;

    @Min(value = 0, message = "El número de entrevistados debe ser al menos 0")
    private int interviewed;

    @Min(value = 0, message = "El número de entrevistados exitosos debe ser al menos 0")
    private int successful_interviewees;

}
