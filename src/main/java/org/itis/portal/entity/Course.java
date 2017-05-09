package org.itis.portal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ainur on 14.04.2017.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column
    private String description;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "lessons_count")
    private Integer lessonsCount;

    @Column(name = "course_number")
    private Integer courseNumber;//  1, 2, 3, 4

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private FileInfo fileInfo;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Student.class)
    List<Student> student;

    public Course() {
    }
    public Course(String courseName,String description,Integer lessonsCount,Integer courseNumber,Teacher teacher) {
        this.courseName=courseName;
        this.description=description;
        //this.createDate=createDate;
        this.lessonsCount=lessonsCount;
        this.courseNumber=courseNumber;
        this.teacher=teacher;
        // this.fileInfo=fileInfo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(Integer lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
