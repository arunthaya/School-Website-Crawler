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

    @Column(name = "location")
    private String schoolLocation;

    @Column(name = "about")
    private String aboutParagraph;

    protected SchoolTable(){
    }

    public SchoolTable(String schoolName, String schoolLocation, String aboutParagraph){
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.aboutParagraph = aboutParagraph;
    }

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
