package org.itis.portal.service;

import org.itis.portal.entity.Course;
import org.itis.portal.entity.Teacher;
import org.itis.portal.repository.CourseRepository;
import org.itis.portal.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ainur on 15.04.2017.
 */
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public void add(Course course) {
        courseRepository.save(course);
    }

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public void delete(Long id) {
        courseRepository.delete(id);
    }

    public List<Course> coursesByCourse (String course) {return courseRepository.findByCourseNumber(Integer.valueOf(course));}

    @Transactional
    public void addTestData() {
        Teacher teacher1= new Teacher("Ференец");
        teacherRepository.save(teacher1);
        Teacher teacher2= new Teacher("Ференец2");
        teacherRepository.save(teacher2);
        Teacher teacher3= new Teacher("Ференец3");
        teacherRepository.save(teacher3);
        Teacher teacher4= new Teacher("Ференец4");
        teacherRepository.save(teacher4);

        Course course1 = new Course("Lamp","1Построение приложений с Web-интерфейсов на базе openSourse-систем (Linux, Apache, MySQL и PHP). \n" +
                "Курс посвящен изучению вопросов совместого использования этих продуктов.",45,1, teacher1);
        courseRepository.save(course1);

        Course course2 = new Course("Lamp","2Построение приложений с Web-интерфейсов .",45,2, teacher2);
        courseRepository.save(course2);

        Course course3 = new Course("Lamp","3Построение приложений с Web-интерфейсов на базе .",45,3, teacher3);
        courseRepository.save(course3);
        Course course4 = new Course("Lamp","4Построение приложений с Web-интерфейсов на базе openSourse-систем ",45,3, teacher4);
        courseRepository.save(course4);

    }
}
