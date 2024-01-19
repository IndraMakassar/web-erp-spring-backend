package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Meeting;
import com.example.weberpspringbackend.model.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingRepository meetingRepository;

    @GetMapping
    public ResponseEntity<Iterable<Meeting>> getAllMeetings() {
        Iterable<Meeting> meetings = meetingRepository.findAll();
        if (!meetings.iterator().hasNext()) {
            return new ResponseEntity<>(meetings, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Meeting> addMeeting(@RequestBody Meeting meeting) {
        meetingRepository.save(meeting);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable long id) {
        Optional<Meeting> meeting = meetingRepository.findById(id);
        return meeting.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}
