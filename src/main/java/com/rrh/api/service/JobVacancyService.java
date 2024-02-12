package com.rrh.api.service;

import com.rrh.api.dto.PercentageDTO;
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

    @Override
    public PercentageDTO calculatePercentage(Long id) {
        Job_vacancy vacancy = this.findVacancy(id);
        if (vacancy == null) {
            throw new IllegalArgumentException("Vacante con id " + id + " no encontrada.");
        }

        int applicants = vacancy.getNumber_applicants();
        if (applicants == 0) {
            return new PercentageDTO(0.0, 0.0,0.0, 0.0,0.0, 0.0); // No hay solicitantes, por lo tanto, el porcentaje de entrevistados y exitosos es cero.
        }

        int interviewed = vacancy.getInterviewed();
        int successful = vacancy.getSuccessful_interviewees();
        int latamApplicants = vacancy.getLatam_applicants();
        int usaApplicants = vacancy.getUsa_applicants();
        int europeApplicants = vacancy.getEurope_applicants();
        int asiaApplicants = vacancy.getAsia_applicants();

        double percentageInterviewed = calculatePercentage(interviewed, applicants);
        double percentageSuccessful = calculatePercentage(successful, applicants);
        double percentageLatam = calculatePercentage(latamApplicants,applicants);
        double percentageUsa = calculatePercentage(usaApplicants,applicants);
        double percentageEurope = calculatePercentage(europeApplicants,applicants);
        double percentageAsia = calculatePercentage(asiaApplicants,applicants);

        return new PercentageDTO(percentageInterviewed, percentageSuccessful,percentageLatam,percentageUsa,percentageEurope,percentageAsia);
    }

    private double calculatePercentage(int value, int total) {
        return ((double) value / total) * 100;
    }





}
