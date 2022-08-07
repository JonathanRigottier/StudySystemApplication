package com.sda.studysystem.utils.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Constraint annotation for unique school validation
 *
 * @author Vinod John
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = {ValidSchoolValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSchool {
    String message() default "{messages.constraints.school-exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
