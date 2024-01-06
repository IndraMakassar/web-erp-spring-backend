package com.example.weberpspringbackend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
