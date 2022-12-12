package com.gradebook.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class School {
    private String schoolId;
    private String name;
    private Collection<Course> coursesBySchoolId;
    private Collection<GbUser> gbUsersBySchoolId;

    @Id
    @Column(name = "school_id", nullable = false, length = 20)
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 100)
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
        School school = (School) o;
        return Objects.equals(schoolId, school.schoolId) && Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, name);
    }

    @OneToMany(mappedBy = "schoolBySchoolId")
    public Collection<Course> getCoursesBySchoolId() {
        return coursesBySchoolId;
    }

    public void setCoursesBySchoolId(Collection<Course> coursesBySchoolId) {
        this.coursesBySchoolId = coursesBySchoolId;
    }

    @OneToMany(mappedBy = "schoolBySchoolId")
    public Collection<GbUser> getGbUsersBySchoolId() {
        return gbUsersBySchoolId;
    }

    public void setGbUsersBySchoolId(Collection<GbUser> gbUsersBySchoolId) {
        this.gbUsersBySchoolId = gbUsersBySchoolId;
    }
}
