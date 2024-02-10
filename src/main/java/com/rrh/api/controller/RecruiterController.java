package com.rrh.api.controller;

import com.rrh.api.model.Recruiter;
import com.rrh.api.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/recruiters")
public class RecruiterController {
    @Autowired
    private IRecruiterService recruiterService;
    @GetMapping
    public ResponseEntity<List<Recruiter>> getRecruiters() {
        try {
            List<Recruiter> recruiters = recruiterService.getRecruiters();
            return ResponseEntity.ok(recruiters);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @PostMapping
    public ResponseEntity<String> saveRecruiter(@RequestBody Recruiter recruiter) {
        try {
            recruiterService.saveRecruiter(recruiter);
            return ResponseEntity.ok("Recruiter creado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el reclutador: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecruiter(@PathVariable Long id) {
        try {
            recruiterService.deleteRecruiter(id);
            return ResponseEntity.ok("Recruiter eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el reclutador: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<Recruiter> editRecruiter(@RequestBody Recruiter recruiter) {
        try {
            recruiterService.editRecruiter(recruiter);
            Recruiter updatedRecruiter = recruiterService.findRecruiter(recruiter.getId());
            return ResponseEntity.ok(updatedRecruiter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
