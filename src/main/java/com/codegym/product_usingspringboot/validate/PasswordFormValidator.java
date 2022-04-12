package com.codegym.product_usingspringboot.validate;

import com.codegym.product_usingspringboot.model.PasswordForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordFormValidator implements ConstraintValidator<PasswordConfirm, PasswordForm> {
    @Override
    public boolean isValid(PasswordForm passwordForm, ConstraintValidatorContext context) {
       return passwordForm.getPassword().equals(passwordForm.getConfirmPassword());
    }
}
