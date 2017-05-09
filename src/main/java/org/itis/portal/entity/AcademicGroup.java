package org.itis.portal.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by thefp on 29.03.2017.
 */
@Entity
@Table(name = "academic_group")
public class AcademicGroup implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, name = "group_number")
    private String groupNumber;

    @Transient
    private List<Student> students;

    private String kurator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getKurator() {
        return kurator;
    }

    public void setKurator(String kurator) {
        this.kurator = kurator;
    }
}
