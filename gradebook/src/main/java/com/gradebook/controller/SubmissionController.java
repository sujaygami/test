package com.gradebook.controller;

import com.gradebook.model.request.StudentAssessmentScore;
import com.gradebook.model.response.SubmissionResponse;
import com.gradebook.service.SubmissionService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Logger
@Validated
@CrossOrigin
@RestController
@RequestMapping(value = "/submission/", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping( "/submitAssessment")
    public ResponseEntity<SubmissionResponse> submitAssessment(
            @RequestBody StudentAssessmentScore studentAssessmentScore,
            @RequestHeader Map<String, String> headers) {
        return submissionService.submitAssessment(studentAssessmentScore);
    }
}
