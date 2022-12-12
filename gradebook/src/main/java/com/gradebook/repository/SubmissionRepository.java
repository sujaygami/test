package com.gradebook.repository;

import com.gradebook.model.Submission;
import com.gradebook.model.SubmissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionPK>{
    List<Submission> findAllByGbUserId(String gbUserId);
    List<Submission> findAllByCourseId(String courseId);
    List<Submission> findAllByGbUserIdAndCourseId(String gbUserId, String courseId);
}

