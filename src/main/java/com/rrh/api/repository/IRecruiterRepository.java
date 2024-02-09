package com.rrh.api.repository;

import com.rrh.api.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecruiterRepository extends JpaRepository<Recruiter, Long> {
}
