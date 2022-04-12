package com.codegym.product_usingspringboot.validate;

import com.codegym.product_usingspringboot.model.User;
import com.codegym.product_usingspringboot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqeUsername,String> {
//    private IUserRepository userRepository;
//    public UniqueUsernameValidator(IUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userRepository.findByUsername(username);
        if(user != null){
            return false;
        }
        return true;
    }
}
