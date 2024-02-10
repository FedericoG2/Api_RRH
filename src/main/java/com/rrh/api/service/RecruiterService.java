package com.rrh.api.service;

import com.rrh.api.model.Recruiter;
import com.rrh.api.repository.IRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService implements IRecruiterService {
    @Autowired
    private IRecruiterRepository recruiterRepository;
    @Override
    public List<Recruiter> getRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return recruiters;
    }

    @Override
    public Recruiter findRecruiter(Long id) {
        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);
        return null;
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
        this.saveRecruiter(recruiter);
    }
}
