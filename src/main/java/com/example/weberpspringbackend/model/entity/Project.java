package com.example.weberpspringbackend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

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
    private ProjectStatus status;
    private Department department;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    @ManyToMany
    private Set<User> member;
}
