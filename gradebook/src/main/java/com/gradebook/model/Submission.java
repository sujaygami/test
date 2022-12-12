package com.gradebook.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(SubmissionPK.class)
@NoArgsConstructor
public class Submission {
    private String gbUserId;
    private String assessmentId;
    private Timestamp dtSubmitted;
    private BigDecimal pointsEarned;
    private GbUser gbUserByGbUserId;
    private Assessment assessmentByAssessmentId;

    public Submission(String courseId, String gbUserId, String assessmentId,
                      Timestamp dtSubmitted, BigDecimal pointsEarned) {
        this.courseId = courseId;
        this.gbUserId = gbUserId;
        this.assessmentId = assessmentId;
        this.dtSubmitted = dtSubmitted;
        this.pointsEarned = pointsEarned;
    }

    private String courseId;
    private Course courseByCourseId;

    @Id
    @Column(name = "gb_user_id", nullable = false, length = 20)
    public String getGbUserId() {
        return gbUserId;
    }

    public void setGbUserId(String gbUserId) {
        this.gbUserId = gbUserId;
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
    @Column(name = "dt_submitted", nullable = false)
    public Timestamp getDtSubmitted() {
        return dtSubmitted;
    }

    public void setDtSubmitted(Timestamp dtSubmitted) {
        this.dtSubmitted = dtSubmitted;
    }

    @Basic
    @Column(name = "points_earned", nullable = true, precision = 2)
    public BigDecimal getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(BigDecimal pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submission that = (Submission) o;
        return Objects.equals(gbUserId, that.gbUserId) && Objects.equals(assessmentId, that.assessmentId) && Objects.equals(dtSubmitted, that.dtSubmitted) && Objects.equals(pointsEarned, that.pointsEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gbUserId, assessmentId, dtSubmitted, pointsEarned);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "gb_user_id", referencedColumnName = "gb_user_id", nullable = false, insertable = false, updatable = false)})
    public GbUser getGbUserByGbUserId() {
        return gbUserByGbUserId;
    }

    public void setGbUserByGbUserId(GbUser gbUserByGbUserId) {
        this.gbUserByGbUserId = gbUserByGbUserId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "assessment_id", referencedColumnName = "assessment_id", nullable = false, insertable = false, updatable = false)})
    public Assessment getAssessmentByAssessmentId() {
        return assessmentByAssessmentId;
    }

    public void setAssessmentByAssessmentId(Assessment assessmentByAssessmentId) {
        this.assessmentByAssessmentId = assessmentByAssessmentId;
    }

    @Basic
    @Column(name = "course_id", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
