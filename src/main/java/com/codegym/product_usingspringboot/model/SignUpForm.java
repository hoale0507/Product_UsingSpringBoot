package com.codegym.product_usingspringboot.model;

import com.codegym.product_usingspringboot.validate.PasswordConfirm;
import com.codegym.product_usingspringboot.validate.UniqeUsername;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.annotations.BatchSize;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    @NotEmpty
    @Size(min = 5, max = 12)
    @UniqeUsername(message = "User is existed!")
    private String username;
    @PasswordConfirm
    private PasswordForm passwordForm;
}
