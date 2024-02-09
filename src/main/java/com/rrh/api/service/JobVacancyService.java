package com.rrh.api.service;

import com.rrh.api.model.Job_vacancy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobVacancyService implements IJobVacancyService {
    @Override
    public List<Job_vacancy> getVacancies() {
        return null;
    }

    @Override
    public Job_vacancy findVacancy(Long id) {
        return null;
    }

    @Override
    public void saveVacancy(Job_vacancy vacancy) {

    }

    @Override
    public void deleteVacancy(Long id) {

    }
}
