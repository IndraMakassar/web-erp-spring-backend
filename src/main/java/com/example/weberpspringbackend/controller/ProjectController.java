package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Project;
import com.example.weberpspringbackend.model.repository.ProjectRepsotory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectRepsotory projectRepsotory;

    @GetMapping
    public ResponseEntity<Iterable<Project>> getAllProject() {
        Iterable<Project> projects = projectRepsotory.findAll();
        if (!projects.iterator().hasNext()) {
            return new ResponseEntity<>(projects, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(projects, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        projectRepsotory.save(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Optional<Project> project = projectRepsotory.findById(id);
        return project.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
