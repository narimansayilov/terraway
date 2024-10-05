package com.terraway.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserRegisterRequest {
    private String email;

    private String password;

    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[A-Za-zƏəÖöÜüŞşÇçığ]+$", message = "Name must contain only Azerbaijani letters")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    @Pattern(regexp = "^[A-Za-zƏəÖöÜüŞşÇçığ]+$", message = "Surname must contain only Azerbaijani letters")
    @NotBlank(message = "Surname cannot be blank")
    private String surname;
}