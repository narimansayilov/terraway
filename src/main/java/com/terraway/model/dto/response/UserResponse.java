package com.terraway.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String photoUrl;
}