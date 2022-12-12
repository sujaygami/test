package com.gradebook.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
public class StudentAssessmentGrades {
    private String courseId;
    private String assignmentId;
    private String assessmentId;
    private String assessmentType;
    private BigDecimal grade;
}
