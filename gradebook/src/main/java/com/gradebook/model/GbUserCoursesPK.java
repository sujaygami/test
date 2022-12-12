package com.gradebook.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GbUserCoursesPK implements Serializable {
    private String courseId;
    private String gbUserId;

    @Column(name = "course_id", nullable = false, length = 20)
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "gb_user_id", nullable = false, length = 20)
    @Id
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
        GbUserCoursesPK that = (GbUserCoursesPK) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(gbUserId, that.gbUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, gbUserId);
    }
}
