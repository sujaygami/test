package com.gradebook.repository;

import com.gradebook.model.GbUserCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GbUserCoursesRepository extends JpaRepository<GbUserCourses, String> {

}