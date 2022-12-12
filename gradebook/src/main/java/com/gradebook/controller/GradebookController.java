package com.gradebook.controller;

import com.gradebook.model.response.OverallGrade;
import com.gradebook.model.response.StudentAssessmentGrades;
import com.gradebook.service.GradebookService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Logger
@Validated
@CrossOrigin
@RestController
@Component
@RequestMapping(value = "/gradebook/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class GradebookController {
    @Autowired
    private GradebookService gradebookService;

    @GetMapping("/{gbUserId}/getAllStudentAssessmentGrades")
    public ResponseEntity<List<StudentAssessmentGrades>> getAllStudentAssessmentGrades(
            @PathVariable("gbUserId") String gbUserId,
            @RequestHeader Map<String, String> headers) throws Exception{
        return gradebookService.getAllStudentAssessmentGrades(gbUserId);
    }

    @GetMapping( "/{gbUserId}/getOverallStudentGrade")
    public ResponseEntity<OverallGrade> getOverallStudentGrade(
            @PathVariable("gbUserId") String gbUserId,
            @RequestHeader Map<String, String> headers) {
        return gradebookService.getOverallStudentGrade(gbUserId);
    }

    @GetMapping( "/{courseId}/getOverallCourseGrade")
    public ResponseEntity<OverallGrade> getOverallCourseGrade(
            @PathVariable("courseId") String courseId,
            @RequestHeader Map<String, String> headers) {
        return gradebookService.getOverallCourseGrade(courseId);
    }
}
