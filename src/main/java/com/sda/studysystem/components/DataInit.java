package com.sda.studysystem.components;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;
import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.CourseService;
import com.sda.studysystem.services.SchoolService;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Component to initialize data on app startup
 *
 * @author Vinod John
 */
@Component
public class DataInit {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    @PostConstruct
    public void init(){
        initSchool();
        //initCourse();
        //initTeacher();
    }

    // PRIVATE METHODS //
    private void initSchool() {
        System.out.println("Starting initializing school...");
        School school = new School();
        school.setName("Viljandi University");
        school.setCity("Viljandi");
        school.setPhone("59698963");
        try {
            schoolService.createSchool(school);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /*private void initCourse() {
        System.out.println("Starting initializing course...");
        Course course = new Course();
        course.setName("Java Spring Boot");
        course.setDurationHours(50.5);

        try {
            Course searchCourse = courseService.findCourseByName(course.getName());
            System.out.println("Already created. Cannot pre-initialize course's name : " + searchCourse.getName());
        } catch (CourseNotFoundException e) {
            courseService.createCourse(course);
        }
    }

     */

    /*private void initTeacher() throws TeacherNotFoundException {
        System.out.println("Starting initializing teacher...");
        Teacher teacher = new Teacher();
        teacher.setFirstName("Jonathan");
        teacher.setLastName("Rigottier");
        teacher.setAddress("A. Weizenbergi 12");
        teacher.setEmail("jonathanrigottier@msn.com");
        teacher.setPhone("51961109");
        try {
            Teacher searchTeacher = teacherService.findTeacherByEmail(teacher.getEmail());
            System.out.println("Already created. Cannot pre-initialize teacher with email : " + searchTeacher.getEmail());
        } catch (TeacherNotFoundException e) {
            teacherService.createTeacher(teacher);
        }
    }

     */
}
