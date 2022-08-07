package com.sda.studysystem.utils.constraints;

import com.sda.studysystem.exceptions.CourseNotFoundException;
import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.Course;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.CourseService;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Constraint validator to check if a course already exists
 *
 * @author Vinod John
 */
@Component
public class ValidCourseValidator implements ConstraintValidator<ValidCourse, Course> {

    @Autowired
    private CourseService courseService;

    @Override
    public void initialize(ValidCourse constraintAnnotation) {
    }

    @Override
    public boolean isValid(Course course, ConstraintValidatorContext constraintValidatorContext) {
        try {
            courseService.findCourseByName(course.getName());
            return false;
        } catch (CourseNotFoundException e) {
            return true;
        }
    }
}
