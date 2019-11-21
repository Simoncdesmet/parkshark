package com.dreamteam.parkshark.api.dtos.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DivisionIdValidator.class)
public @interface ExistingDivisionId {
    String message() default "parent division does not exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
