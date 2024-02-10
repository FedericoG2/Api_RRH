package com.rrh.api.controller;

import com.rrh.api.model.Recruiter;
import com.rrh.api.service.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecruiterController {
    @Autowired
    private IRecruiterService recruiterService;
    @GetMapping("/recruiters")
    public List<Recruiter> getRecruiters(){
        List<Recruiter> recruiters = recruiterService.getRecruiters();
        return recruiters;
    }
    @PostMapping("/recruiter/crear")
    public String saveRecruiter(@RequestBody Recruiter recruiter){
        recruiterService.saveRecruiter(recruiter);
        return "Recruiter creado con exito";
    }
    @DeleteMapping("/recruiter/eliminar/{id}")
    public String deleteRecruiter(@PathVariable Long id){
        recruiterService.deleteRecruiter(id);
        return "Recruiter eliminado";
    }
    @PutMapping("/recruiter/editar")
    public Recruiter editRecruiter(@RequestBody Recruiter recruiter){
        recruiterService.editRecruiter(recruiter);
        Recruiter findRecruiter = recruiterService.findRecruiter(recruiter.getId());
        return findRecruiter;
    }
}
