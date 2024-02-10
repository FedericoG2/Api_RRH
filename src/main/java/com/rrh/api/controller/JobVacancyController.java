package com.rrh.api.controller;

import com.rrh.api.model.Job_vacancy;
import com.rrh.api.service.IJobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobVacancyController {
    @Autowired
    private IJobVacancyService jobVacancyService;

    @GetMapping("/vacantes")
    public List<Job_vacancy> getVacancies(){
        List<Job_vacancy> vacancies = jobVacancyService.getVacancies();
        return vacancies;
    }
    @PostMapping("/vacante/crear")
    public String saveVacancy(@RequestBody Job_vacancy vacancy) {
        jobVacancyService.saveVacancy(vacancy);
        return "Vacante creada con exito";
    }
    @DeleteMapping("/vacante/eliminar/{id}")
    public String deleteVacancy(@PathVariable Long id){
        jobVacancyService.deleteVacancy(id);
        return "Vacante eliminada";
    }
    @PutMapping("/vacante/editar")
    public Job_vacancy editVacancy(@RequestBody Job_vacancy vacancy){
        jobVacancyService.editVacancy(vacancy);
        Job_vacancy editedVacancy = jobVacancyService.findVacancy(vacancy.getId());
        return editedVacancy;
    }

}
