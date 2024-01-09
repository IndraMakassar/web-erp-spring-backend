package com.example.weberpspringbackend.model.entity;

import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "finance")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String source;
    private Double Total;
    private Timestamp Date;
    private String Description;
}