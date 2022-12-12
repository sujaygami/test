package com.gradebook.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gb_user_courses", schema = "public", catalog = "postgres")
@IdClass(GbUserCoursesPK.class)
public class GbUserCourses {
    private String courseId;
    private String gbUserId;
    private Course courseByCourseId;
    private GbUser gbUserByGbUserId;

    @Id
    @Column(name = "course_id", nullable = false, length = 20)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "gb_user_id", nullable = false, length = 20)
    public String getGbUserId() {
        return gbUserId;
    }

    public void setGbUserId(String gbUserId) {
        this.gbUserId = gbUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GbUserCourses that = (GbUserCourses) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(gbUserId, that.gbUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, gbUserId);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)})
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "gb_user_id", referencedColumnName = "gb_user_id", nullable = false, insertable = false, updatable = false)})
    public GbUser getGbUserByGbUserId() {
        return gbUserByGbUserId;
    }

    public void setGbUserByGbUserId(GbUser gbUserByGbUserId) {
        this.gbUserByGbUserId = gbUserByGbUserId;
    }
}
