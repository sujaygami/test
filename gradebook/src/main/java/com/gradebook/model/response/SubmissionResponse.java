package com.gradebook.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class SubmissionResponse {
    private OverallGrade overallStudentGradeInCourse;
    private OverallGrade overallCourseGrade;
}
