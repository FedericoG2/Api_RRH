package com.rrh.api.service;

import com.rrh.api.model.Recruiter;

import java.util.List;

public interface IRecruiterService {
    public List<Recruiter> getRecruiters();

    public Recruiter findRecruiter(Long id);
    public void saveRecruiter(Recruiter recruiter);

    public void deleteRecruiter(Long id);

    public void editRecruiter(Recruiter recruiter);

}
