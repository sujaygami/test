package com.gradebook.service.impl;

import com.gradebook.model.Assessment;
import com.gradebook.model.Assignment;
import com.gradebook.model.Course;
import com.gradebook.model.Submission;
import com.gradebook.model.response.OverallGrade;
import com.gradebook.model.response.StudentAssessmentGrades;
import com.gradebook.repository.AssessmentRepository;
import com.gradebook.repository.AssignmentRepository;
import com.gradebook.repository.CourseRepository;
import com.gradebook.repository.SubmissionRepository;
import com.gradebook.service.GradebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradebookServiceImpl implements GradebookService {
    @Autowired
    SubmissionRepository submissionRepository;

    @Autowired
    AssessmentRepository assessmentRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    CourseRepository courseRepository;

    public ResponseEntity<List<StudentAssessmentGrades>> getAllStudentAssessmentGrades(String gbUserId) throws Exception {
        List<StudentAssessmentGrades> listOfStudentAssessmentGrades = new ArrayList<>();
        List<Submission> studentSubmissions = submissionRepository.findAllByGbUserId(gbUserId);

        for(Submission submission : studentSubmissions){
            Assessment assessment = getAssessment(submission.getAssessmentId());
            Assignment assignment = getAssignment(assessment.getAssignmentId());
            Course course = getCourse(assignment.getCourseId());
            StudentAssessmentGrades studentAssessmentGrades = new StudentAssessmentGrades(
                    course.getCourseId(),
                    assignment.getAssignmentId(),
                    submission.getAssessmentId(),
                    assessment.getType(),
                    submission.getPointsEarned());
            listOfStudentAssessmentGrades.add(studentAssessmentGrades);
        }

        return new ResponseEntity<>(listOfStudentAssessmentGrades, HttpStatus.OK);
    }

    public ResponseEntity<OverallGrade> getOverallStudentGrade(String gbUserId){
        List<Submission> studentSubmissions = submissionRepository.findAllByGbUserId(gbUserId);
        OverallGrade overallStudentGrade = new OverallGrade(calculateAverage(studentSubmissions));
        return new ResponseEntity<>(overallStudentGrade, HttpStatus.OK);
    }

    public ResponseEntity<OverallGrade> getOverallCourseGrade(String courseId){
        List<Submission> courseSubmissions = submissionRepository.findAllByCourseId(courseId);
        OverallGrade overallCourseGrade = new OverallGrade(calculateAverage(courseSubmissions));
        return new ResponseEntity<>(overallCourseGrade, HttpStatus.OK);
    }

    public ResponseEntity<OverallGrade> getOverallStudentGradeInCourse(String gbUserId, String courseId){
        List<Submission> submissions = submissionRepository
                .findAllByGbUserIdAndCourseId(gbUserId, courseId);
        OverallGrade overallStudentGradeInCourse = new OverallGrade(calculateAverage(submissions));
        return new ResponseEntity<>(overallStudentGradeInCourse, HttpStatus.OK);
    }

    private Assessment getAssessment(String submissionId) throws Exception{
        return assessmentRepository.findById(submissionId).orElseThrow(Exception::new);
    }

    private Assignment getAssignment(String assignmentId) throws Exception{
        return assignmentRepository.findById(assignmentId).orElseThrow(Exception::new);
    }

    private Course getCourse(String courseId) throws Exception{
        return courseRepository.findById(courseId).orElseThrow(Exception::new);
    }

    private BigDecimal calculateAverage(List<Submission> submissions){
        BigDecimal total = submissions
                .stream()
                .map(Submission::getPointsEarned)
                .reduce(BigDecimal::add)
                .get();
        return total.divide(new BigDecimal(submissions.size()), RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.CEILING);
    }
}
