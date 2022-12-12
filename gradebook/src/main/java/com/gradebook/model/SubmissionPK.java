package com.gradebook.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SubmissionPK implements Serializable {
    private String gbUserId;
    private String assessmentId;

    @Column(name = "gb_user_id", nullable = false, length = 20)
    @Id
    public String getGbUserId() {
        return gbUserId;
    }

    public void setGbUserId(String gbUserId) {
        this.gbUserId = gbUserId;
    }

    @Column(name = "assessment_id", nullable = false, length = 20)
    @Id
    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionPK that = (SubmissionPK) o;
        return Objects.equals(gbUserId, that.gbUserId) && Objects.equals(assessmentId, that.assessmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gbUserId, assessmentId);
    }
}
