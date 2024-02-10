package com.rrh.api.service;

import com.rrh.api.model.Recruiter;
import com.rrh.api.repository.IRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService implements IRecruiterService {
    @Autowired
    private IRecruiterRepository recruiterRepository;

    @Override
    public List<Recruiter> getRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter findRecruiter(Long id) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);
        return optionalRecruiter.orElse(null);
    }

    @Override
    public void saveRecruiter(Recruiter recruiter) {
        recruiterRepository.save(recruiter);
    }

    @Override
    public void deleteRecruiter(Long id) {
        recruiterRepository.deleteById(id);
    }

    @Override
    public void editRecruiter(Recruiter recruiter) {
        saveRecruiter(recruiter);
    }
}
