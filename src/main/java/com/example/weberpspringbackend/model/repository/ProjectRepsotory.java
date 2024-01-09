package com.example.weberpspringbackend.model.repository;

import com.example.weberpspringbackend.model.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepsotory extends CrudRepository<Project, Long> {
}
