package com.example.springbootwithreactjs.DAO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schooltable")
public class SchoolTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String schoolName;


}
