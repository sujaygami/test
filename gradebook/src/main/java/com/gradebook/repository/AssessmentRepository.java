package com.gradebook.repository;

import com.gradebook.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, String> {
    Optional<Assessment> findById(String assessmentId);
}
