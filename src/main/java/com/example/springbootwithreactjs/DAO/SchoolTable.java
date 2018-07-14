package com.example.springbootwithreactjs.DAO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schooltable")
public class SchoolTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    @Column(name = "school", nullable = false)
    private String schoolName;

    @Column(name = "location", nullable = false)
    private String schoolLocation;

    @Column(name = "about", nullable = false)
    private String aboutParagraph;

    public Long get_id() {
        return _id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public String getAboutParagraph() {
        return aboutParagraph;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public void setAboutParagraph(String aboutParagraph) {
        this.aboutParagraph = aboutParagraph;
    }
}
