package com.gradebook.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "gb_user", schema = "public", catalog = "postgres")
public class GbUser {
    private String gbUserId;
    private String firstName;
    private String lastName;
    private String type;
    private String schoolId;
    private School schoolBySchoolId;
    private Collection<GbUserCourses> gbUserCoursesByGbUserId;
    private Collection<Submission> submissionsByGbUserId;

    @OneToMany(mappedBy = "gbUserByGbUserId")
    public Collection<Submission> getSubmissionsByGbUserId() {
        return submissionsByGbUserId;
    }

    public void setSubmissionsByGbUserId(Collection<Submission> submissionsByGbUserId) {
        this.submissionsByGbUserId = submissionsByGbUserId;
    }

    @Id
    @Column(name = "gb_user_id", nullable = false, length = 20)
    public String getGbUserId() {
        return gbUserId;
    }

    public void setGbUserId(String gbUserId) {
        this.gbUserId = gbUserId;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GbUser gbUser = (GbUser) o;
        return Objects.equals(gbUserId, gbUser.gbUserId) && Objects.equals(firstName, gbUser.firstName) && Objects.equals(lastName, gbUser.lastName) && Objects.equals(type, gbUser.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gbUserId, firstName, lastName, type);
    }

    @Basic
    @Column(name = "school_id", nullable = false, length = 20)
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false, insertable = false, updatable = false)})
    public School getSchoolBySchoolId() {
        return schoolBySchoolId;
    }

    public void setSchoolBySchoolId(School schoolBySchoolId) {
        this.schoolBySchoolId = schoolBySchoolId;
    }

    @OneToMany(mappedBy = "gbUserByGbUserId")
    public Collection<GbUserCourses> getGbUserCoursesByGbUserId() {
        return gbUserCoursesByGbUserId;
    }

    public void setGbUserCoursesByGbUserId(Collection<GbUserCourses> gbUserCoursesByGbUserId) {
        this.gbUserCoursesByGbUserId = gbUserCoursesByGbUserId;
    }
}
