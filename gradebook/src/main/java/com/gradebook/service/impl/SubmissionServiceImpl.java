package com.gradebook.service.impl;

import com.gradebook.model.Submission;
import com.gradebook.model.request.StudentAssessmentScore;
import com.gradebook.model.response.OverallGrade;
import com.gradebook.model.response.SubmissionResponse;
import com.gradebook.repository.SubmissionRepository;
import com.gradebook.service.GradebookService;
import com.gradebook.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    GradebookService gradebookService;

    public ResponseEntity<SubmissionResponse> submitAssessment(StudentAssessmentScore studentAssessmentScore) {
        Submission newSubmission = new Submission(
            studentAssessmentScore.getCourseId(),
            studentAssessmentScore.getGbUserId(),
            studentAssessmentScore.getAssessmentId(),
            studentAssessmentScore.getDtSubmitted(),
            studentAssessmentScore.getScore().getPointsEarned());
        submissionRepository.save(newSubmission);

        OverallGrade overallCourseGrade = gradebookService.getOverallCourseGrade(studentAssessmentScore.getCourseId()).getBody();
        OverallGrade overallStudentGradeInCourse = gradebookService.getOverallStudentGradeInCourse(studentAssessmentScore.getGbUserId(), studentAssessmentScore.getCourseId()).getBody();
        SubmissionResponse submissionResponse = new SubmissionResponse(overallStudentGradeInCourse, overallCourseGrade);
        return new ResponseEntity<>(submissionResponse, HttpStatus.OK);
    }



}
