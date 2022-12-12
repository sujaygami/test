package com.gradebook.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Assessment {
    private String assessmentId;
    private String type;
    private int pointsPossible;
    private String assignmentId;
    private Assignment assignmentByAssignmentId;
    private Collection<Submission> submissionsByAssessmentId;

    @OneToMany(mappedBy = "assessmentByAssessmentId")
    public Collection<Submission> getSubmissionsByAssessmentId() {
        return submissionsByAssessmentId;
    }

    public void setSubmissionsByAssessmentId(Collection<Submission> submissionsByAssessmentId) {
        this.submissionsByAssessmentId = submissionsByAssessmentId;
    }

    @Id
    @Column(name = "assessment_id", nullable = false, length = 20)
    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "points_possible", nullable = false)
    public int getPointsPossible() {
        return pointsPossible;
    }

    public void setPointsPossible(int pointsPossible) {
        this.pointsPossible = pointsPossible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assessment that = (Assessment) o;
        return pointsPossible == that.pointsPossible && Objects.equals(assessmentId, that.assessmentId) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assessmentId, type, pointsPossible);
    }

    @Basic
    @Column(name = "assignment_id", nullable = false, length = 20)
    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id", nullable = false, insertable = false, updatable = false)})
    public Assignment getAssignmentByAssignmentId() {
        return assignmentByAssignmentId;
    }

    public void setAssignmentByAssignmentId(Assignment assignmentByAssignmentId) {
        this.assignmentByAssignmentId = assignmentByAssignmentId;
    }
}
