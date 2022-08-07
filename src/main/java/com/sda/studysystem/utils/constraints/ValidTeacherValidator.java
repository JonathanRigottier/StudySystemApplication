package com.sda.studysystem.utils.constraints;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.exceptions.TeacherNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.models.Teacher;
import com.sda.studysystem.services.SchoolService;
import com.sda.studysystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Constraint validator to check if a teacher already exists
 *
 * @author Vinod John
 */
@Component
public class ValidTeacherValidator implements ConstraintValidator<ValidTeacher, Teacher> {
    @Autowired
    private TeacherService teacherService;

    @Override
    public void initialize(ValidTeacher constraintAnnotation) {
    }

    @Override
    public boolean isValid(Teacher teacher, ConstraintValidatorContext constraintValidatorContext) {
        try {
            teacherService.findTeacherByEmail(teacher.getEmail());
            return false;
        } catch (TeacherNotFoundException e) {
            return true;
        }
    }
}
