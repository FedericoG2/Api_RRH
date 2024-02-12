package com.rrh.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PercentageDTO {
    private double percentageInterviewed;
    private double percentageSuccessful;
    private double percentageLatamApplicants;
    private double percentageUsaApplicants;
    private double percentageEuropeApplicants;
    private double percentageAsiaApplicants;

}
