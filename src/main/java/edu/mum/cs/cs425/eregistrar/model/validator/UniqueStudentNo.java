package edu.mum.cs.cs425.eregistrar.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueStudentNoValidator.class)
public @interface UniqueStudentNo {
    String message() default "{edu.mum.cs.cs425.eregistrar.customvalidators.uniquestudentnumber.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
