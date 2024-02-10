package com.rrh.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job_vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String work_modality;
    private List<String> technologies;
    private List<String> requirements;
    private List<String> countries;
    private int number_applicants;
    private int interviewed;
    private int Successful_interviewees;

//    @ManyToOne
//    @JoinColumn(name = "recruiter_id")
//    private Recruiter recruiter;

}
