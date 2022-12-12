package com.gradebook.service;

import com.gradebook.model.request.StudentAssessmentScore;
import com.gradebook.model.response.SubmissionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface SubmissionService {
    ResponseEntity<SubmissionResponse> submitAssessment(StudentAssessmentScore studentAssessmentScore);

}
