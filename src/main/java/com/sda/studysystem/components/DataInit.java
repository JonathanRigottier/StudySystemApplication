package com.sda.studysystem.components;

import com.sda.studysystem.exceptions.*;
import com.sda.studysystem.models.*;
import com.sda.studysystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.sda.studysystem.utils.Constants.Security.*;

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

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        initSchoolData();
        initCourseData();
        initTeacherData();
        initAuthorityData();
        initUserData();
    }

    // PRIVATE METHODS //
    private void initSchoolData() {
        System.out.println("Starting initializing school...");
        School school = new School();
        school.setName("Viljandi University");
        school.setCity("Viljandi");
        school.setPhone("59698963");
        try {
            School searchSchool = schoolService.findSchoolByName(school.getName());
            System.out.println("Already created. Cannot pre-initialize school with name : " + searchSchool.getName());
        } catch (SchoolNotFoundException e) {
            schoolService.createSchool(school);
        }
    }

    private void initCourseData() {
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

    private void initTeacherData() {
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

    private void initAuthorityData() {
        System.out.println("Starting initializing Authority...");
        Authority authorityAdmin = new Authority();
        authorityAdmin.setName(AUTHORITY_ADMIN);
        createAuthority(authorityAdmin);

        Authority authorityTeacher = new Authority();
        authorityTeacher.setName(AUTHORITY_TEACHER);
        createAuthority(authorityTeacher);

        Authority authorityStudent = new Authority();
        authorityStudent.setName(AUTHORITY_STUDENT);
        createAuthority(authorityStudent);
    }

    private void initUserData() {
        System.out.println("Starting initializing User...");

        try {
            Authority authority = authorityService.findAuthorityByName(AUTHORITY_ADMIN);

            User user = new User();
            user.setUserName("admin@study.com");
            user.setPassword("123456");
            user.setAuthority(authority);

            try {
                User resultUser =  userService.findUserByUserName(user.getUserName());
                System.out.println("Cannot pre-initialize user:" + resultUser.getUserName());
            } catch (UserNotFoundException e) {
                userService.createUser(user);
            }

        } catch (AuthorityNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    private void createAuthority(Authority authority) {
        try {
            Authority resultAuthority = authorityService.findAuthorityByName(authority.getName());
            System.out.println("Already created. Cannot pre-initialize authority: " + resultAuthority.getName());
        } catch (AuthorityNotFoundException authorityNotFoundException) {
            authorityService.createAuthority(authority);
        }
    }
}
