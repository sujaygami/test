package com.gradebook.service;

import com.gradebook.model.response.OverallGrade;
import com.gradebook.model.response.StudentAssessmentGrades;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface GradebookService {
    ResponseEntity<List<StudentAssessmentGrades>> getAllStudentAssessmentGrades(String gbUserId) throws Exception;
    ResponseEntity<OverallGrade> getOverallStudentGrade(String gbUserId);
    ResponseEntity<OverallGrade> getOverallCourseGrade(String courseId);
    ResponseEntity<OverallGrade> getOverallStudentGradeInCourse(String gbUserId, String courseId);
}
