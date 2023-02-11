package com.project.mongoproto.annotation;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateField.class)
public @interface Searchable {

    long id() default 0;
    String key() default "";
}
