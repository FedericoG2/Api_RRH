package com.rrh.api.controller;

import com.rrh.api.dto.PercentageDTO;
import com.rrh.api.model.Job_vacancy;
import com.rrh.api.service.IJobVacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/vacancies")
public class JobVacancyController {
    @Autowired
    private IJobVacancyService jobVacancyService;

    @GetMapping
    public ResponseEntity<List<Job_vacancy>> getVacancies() {
        try {
            List<Job_vacancy> vacancies = jobVacancyService.getVacancies();
            return ResponseEntity.ok(vacancies);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @PostMapping
    public ResponseEntity<String> postVacancy(@Valid @RequestBody Job_vacancy vacancy, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {

                if (bindingResult.getFieldError() != null) {
                    return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
                } else {
                    return ResponseEntity.badRequest().body("Revise los campos");
                }
            } else {
                jobVacancyService.saveVacancy(vacancy);
                return ResponseEntity.ok("Vacante creada exitosamente");
            }
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear la vacante: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long id) {
        try {
            jobVacancyService.deleteVacancy(id);
            return ResponseEntity.ok("Vacante eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar la vacante: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Job_vacancy> editVacancy(@RequestBody Job_vacancy vacancy) {
        try {
            jobVacancyService.editVacancy(vacancy);
            Job_vacancy vacanteEditada = jobVacancyService.findVacancy(vacancy.getId());
            return ResponseEntity.ok(vacanteEditada);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @GetMapping("/statics/{id}")
    public ResponseEntity<PercentageDTO> getStatics(@PathVariable Long id) {
        try {
            PercentageDTO percentageDTO = jobVacancyService.calculatePercentage(id);
            return ResponseEntity.ok(percentageDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }




}
