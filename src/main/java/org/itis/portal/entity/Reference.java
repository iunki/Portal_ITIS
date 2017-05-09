package org.itis.portal.entity;

import org.itis.portal.entity.prototypes.BaseModel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by thefp on 02.05.2017.
 */
@Entity
@Table(name = "references")
public class Reference extends BaseModel {

    @Column(name = "count")
    private Integer count;

    @ManyToOne
    private Student student;

    @Column(name = "date_reference")
    private Date date;

    @Column(name = "issued")
    private boolean issued;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}
