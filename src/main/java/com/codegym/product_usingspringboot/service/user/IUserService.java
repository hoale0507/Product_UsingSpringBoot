package com.codegym.product_usingspringboot.service.user;


import com.codegym.product_usingspringboot.model.User;
import com.codegym.product_usingspringboot.service.IGenneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGenneralService<User>, UserDetailsService {
    User findByUsername(String username);
}
// UserDetailsService dung de load du lieu tu DB

