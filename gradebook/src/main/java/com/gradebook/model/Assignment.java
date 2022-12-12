package com.gradebook.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Assignment {
    private String assignmentId;
    private Course courseByCourseId;
    private String courseId;
    private Collection<Assessment> assessmentsByAssignmentId;

    @Id
    @Column(name = "assignment_id", nullable = false, length = 20)
    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(assignmentId, that.assignmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)})
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @Basic
    @Column(name = "course_id", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @OneToMany(mappedBy = "assignmentByAssignmentId")
    public Collection<Assessment> getAssessmentsByAssignmentId() {
        return assessmentsByAssignmentId;
    }

    public void setAssessmentsByAssignmentId(Collection<Assessment> assessmentsByAssignmentId) {
        this.assessmentsByAssignmentId = assessmentsByAssignmentId;
    }
}
