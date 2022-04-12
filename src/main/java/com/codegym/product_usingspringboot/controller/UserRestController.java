package com.codegym.product_usingspringboot.controller;


import com.codegym.product_usingspringboot.model.JwtResponse;
import com.codegym.product_usingspringboot.model.Role;
import com.codegym.product_usingspringboot.model.SignUpForm;
import com.codegym.product_usingspringboot.model.User;
import com.codegym.product_usingspringboot.service.JwtService;
import com.codegym.product_usingspringboot.service.role.IRoleService;
import com.codegym.product_usingspringboot.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserRestController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        //Kiểm tra username và pass có đúng hay không, Authentication là lớp có sẵn của Spring
        // nếu validate thì tạo đối tượng authentication để lưu user,pass của user đang đăng nhập
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        //Lưu user đang đăng nhập vào trong context của security
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //Tạo chuỗi jwt từ user đang đăng nhập
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody SignUpForm user){
//        if(!user.getPasswordForm().getPassword().equals(user.getPasswordForm().getConfirmPassword())){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
            User newUser = new User(user.getUsername(),user.getPasswordForm().getPassword());
        return new ResponseEntity<>(userService.save(newUser), HttpStatus.CREATED);
    }
}
