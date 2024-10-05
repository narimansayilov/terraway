package com.terraway.model.dto.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCriteriaRequest {
    private String email;
    private Boolean status;
}
