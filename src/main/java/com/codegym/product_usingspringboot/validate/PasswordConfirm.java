package com.codegym.product_usingspringboot.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordFormValidator.class})
public @interface PasswordConfirm {
    String message() default "Re-password not match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
