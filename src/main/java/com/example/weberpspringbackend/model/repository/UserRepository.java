package com.example.weberpspringbackend.model.repository;

import com.example.weberpspringbackend.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
