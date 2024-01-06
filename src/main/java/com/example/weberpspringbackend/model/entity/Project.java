package com.example.weberpspringbackend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "project")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Status status;
    private String department;
}