package com.example.weberpspringbackend.model.repository;

import com.example.weberpspringbackend.model.entity.Meeting;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
