package com.sda.studysystem.utils.constraints;

import com.sda.studysystem.exceptions.SchoolNotFoundException;
import com.sda.studysystem.models.School;
import com.sda.studysystem.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Constraint validator to check if school already exists
 *
 * @author Vinod John
 */
@Component
public class ValidSchoolValidator implements ConstraintValidator<ValidSchool, School> {
    @Autowired
    private SchoolService schoolService;

    @Override
    public void initialize(ValidSchool constraintAnnotation) {
    }

    @Override
    public boolean isValid(School school, ConstraintValidatorContext constraintValidatorContext) {
        try {
            schoolService.findSchoolByName(school.getName());
            return false;
        } catch (SchoolNotFoundException e) {
            return true;
        }
    }
}
