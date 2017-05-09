package org.itis.portal.entity;

import org.itis.portal.entity.prototypes.NamedModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"laboratory\"")
public class Laboratory extends NamedModel {

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @OneToMany(mappedBy = "laboratory")
    private List<Student> students;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        student.setLaboratory(this);
        this.students.add(student);
    }
}