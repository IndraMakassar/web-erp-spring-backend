package com.example.weberpspringbackend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "meeting")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User creator;
    @ManyToMany
    private Set<User> participant;
    private String purpose;
    private String topic;
    private Timestamp timeStart;
    private Timestamp timeEnd;
    private String location;
    private byte[] MoM;
}
