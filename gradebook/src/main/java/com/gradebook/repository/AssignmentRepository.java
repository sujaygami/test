package com.gradebook.repository;

import com.gradebook.model.Assignment;
import com.gradebook.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    Course findCourseByAssignmentId(String assignmentId);
    Optional<Assignment> findById(String assignmentId);

}
