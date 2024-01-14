package com.example.weberpspringbackend.model;

import com.example.weberpspringbackend.model.entity.Department;
import com.example.weberpspringbackend.model.entity.UserPosition;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private Department department;
    private UserPosition position;
}
