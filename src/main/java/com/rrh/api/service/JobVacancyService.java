package com.rrh.api.service;

import com.rrh.api.model.Job_vacancy;
import com.rrh.api.repository.IJobVacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobVacancyService implements IJobVacancyService {
    @Autowired
    private IJobVacancyRepository jobVancyRepository;

    @Override
    public List<Job_vacancy> getVacancies() {
        return jobVancyRepository.findAll();
    }

    @Override
    public Job_vacancy findVacancy(Long id) {
        Optional<Job_vacancy> optionalVacancy = jobVancyRepository.findById(id);
        return optionalVacancy.orElse(null);
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
        saveVacancy(vacancy);
    }
}
