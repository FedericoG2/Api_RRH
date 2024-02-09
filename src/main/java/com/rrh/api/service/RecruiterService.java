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
        return null;
    }

    @Override
    public void saveRecruiter(Recruiter recruiter) {

    }

    @Override
    public void deleteRecruiter(Long id) {

    }

    @Override
    public void editRecruiter(Recruiter recruiter) {

    }
}
