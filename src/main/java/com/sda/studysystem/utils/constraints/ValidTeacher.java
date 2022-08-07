package com.sda.studysystem.utils.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint annotation for unique teacher validation
 *
 * @author Vinod John
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = {ValidTeacherValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTeacher {
    String message() default "{messages.constraints.teacher-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
