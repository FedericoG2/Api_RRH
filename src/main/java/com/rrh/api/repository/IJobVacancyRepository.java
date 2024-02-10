package com.rrh.api.repository;

import com.rrh.api.model.Job_vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobVacancyRepository extends JpaRepository<Job_vacancy,Long> {
}
