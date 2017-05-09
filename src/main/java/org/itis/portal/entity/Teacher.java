package org.itis.portal.entity;

import javax.persistence.*;

/**
 * Created by thefp on 29.03.2017.
 */
@Entity
@Table(name = "teacher")
public class Teacher implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Teacher (String fullName){
        this.fullName=fullName;

    }
    public Teacher (){


    }
}
