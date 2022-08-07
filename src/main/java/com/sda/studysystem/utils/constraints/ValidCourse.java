package com.sda.studysystem.utils.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint annotation for unique course validation
 *
 * @author Vinod John
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = {ValidCourseValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCourse {
    String message() default "{messages.constraints.course-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
