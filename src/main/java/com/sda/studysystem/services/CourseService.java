package com.sda.studysystem.services;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;

import java.util.List;

/**
 * To handle school related operations
 *
 * @author Rigottier Jonathan
 */

public interface CourseService {
    /**
     * To create a new course
     * @param course Course
     */
    void createCourse(Course course);

    /**
     * To find a course by its ID
     * @param id id of the course
     * @return Course
     */
    Course findCourseById(Long id) throws CourseNotFoundException;

    /**
     * To find a course by its name
     * @param name name of the course
     * @return Course
     */
    Course findCourseByName(String name) throws CourseNotFoundException;

    /**
     * To find all courses
     * @return List of courses
     */
    List<Course> findAllCourses();

    /**
     * To update an existing course
     * @param course Course
     */
    void updateCourse(Course course) throws CourseNotFoundException;

    /**
     * To delete course by its ID
     * @param id id of the course
     */
    void deleteCourseById(Long id) throws CourseNotFoundException;

    /**
     * To restore a course by its ID
     * @param id
     */
    void restoreCourseById(Long id) throws CourseNotFoundException;
}
