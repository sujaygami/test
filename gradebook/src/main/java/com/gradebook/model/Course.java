package com.gradebook.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Course {
    private String courseId;
    private String name;
    private String schoolId;
    private Collection<Assignment> assignmentsByCourseId;
    private School schoolBySchoolId;
    private Collection<GbUserCourses> gbUserCoursesByCourseId;
    private Collection<Submission> submissionsByCourseId;

    @Id
    @Column(name = "course_id", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, name);
    }

    @Basic
    @Column(name = "school_id", nullable = false, length = 20)
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Assignment> getAssignmentsByCourseId() {
        return assignmentsByCourseId;
    }

    public void setAssignmentsByCourseId(Collection<Assignment> assignmentsByCourseId) {
        this.assignmentsByCourseId = assignmentsByCourseId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false, insertable = false, updatable = false)})
    public School getSchoolBySchoolId() {
        return schoolBySchoolId;
    }

    public void setSchoolBySchoolId(School schoolBySchoolId) {
        this.schoolBySchoolId = schoolBySchoolId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<GbUserCourses> getGbUserCoursesByCourseId() {
        return gbUserCoursesByCourseId;
    }

    public void setGbUserCoursesByCourseId(Collection<GbUserCourses> gbUserCoursesByCourseId) {
        this.gbUserCoursesByCourseId = gbUserCoursesByCourseId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<Submission> getSubmissionsByCourseId() {
        return submissionsByCourseId;
    }

    public void setSubmissionsByCourseId(Collection<Submission> submissionsByCourseId) {
        this.submissionsByCourseId = submissionsByCourseId;
    }
}
