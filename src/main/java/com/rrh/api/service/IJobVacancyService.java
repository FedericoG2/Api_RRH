package com.rrh.api.service;

import com.rrh.api.model.Job_vacancy;

import java.util.List;

public interface IJobVacancyService {

    public List<Job_vacancy> getVacancies();
    public Job_vacancy findVacancy(Long id);

    public void saveVacancy(Job_vacancy vacancy);

    public void deleteVacancy(Long id);

    public void editVacancy(Job_vacancy vacancy);
}
