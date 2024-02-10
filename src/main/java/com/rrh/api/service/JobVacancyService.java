package com.rrh.api.service;

import com.rrh.api.model.Job_vacancy;
import com.rrh.api.repository.IJobVancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobVacancyService implements IJobVacancyService {
    @Autowired
    IJobVancyRepository jobVancyRepository;
    @Override
    public List<Job_vacancy> getVacancies() {
        List<Job_vacancy> vacancies = jobVancyRepository.findAll();
        return vacancies;
    }

    @Override
    public Job_vacancy findVacancy(Long id) {
        Job_vacancy vacancy = jobVancyRepository.findById(id).orElse(null);
        return vacancy;
    }

    @Override
    public void saveVacancy(Job_vacancy vacancy) {
        jobVancyRepository.save(vacancy);

    }

    @Override
    public void deleteVacancy(Long id) {
        jobVancyRepository.deleteById(id);

    }

    @Override
    public void editVacancy(Job_vacancy vacancy) {
        this.saveVacancy(vacancy);
    }
}
