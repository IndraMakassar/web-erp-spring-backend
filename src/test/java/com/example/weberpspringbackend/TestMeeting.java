// package com.example.weberpspringbackend;

// import java.util.HashSet;
// import java.util.Set;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

// import com.example.weberpspringbackend.model.entity.Department;
// import com.example.weberpspringbackend.model.entity.Meeting;
// import com.example.weberpspringbackend.model.entity.Role;
// import com.example.weberpspringbackend.model.entity.User;
// import com.example.weberpspringbackend.model.entity.UserPosition;
// import com.example.weberpspringbackend.model.repository.MeetingRepository;
// import com.example.weberpspringbackend.model.repository.UserRepository;

// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

// @SpringBootTest
// @AutoConfigureMockMvc
// class TestMeeting {

//     @Autowired
//     private MockMvc MockMvc;
//     @Autowired
//     private MeetingRepository meetingRepository;
//     @Autowired
//     private UserRepository userRepository;

//     @Test
//     public void testMeeting() {
//         Meeting meeting = new Meeting();
//         User user = new User("indra123@gmail.com", "indra", Department.ICT, UserPosition.Leader, "LALALALALA",
//             Role.ADMIN);

//         Set<User> participants = new HashSet<>();
//         participants.add(user);

//         meeting.setCreator(user);
//         meeting.setParticipant(participants);
//         meeting.setLocation("kampus unhas");
//         meeting.setPurpose("turu");
//         meeting.setTimeStart(null);
//         meeting.setTimeEnd(null);
//         meeting.setTopic("MAMAM");

//         MockMvc.perform(MockMvcRequestBuilders.post("/api/v1/meetings")
//         .contentType(MediaType.APPLICATION_JSON)
//         .content())
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andExpect(jsonPath("$.topic").value("MAMAM"))
//         .andExpect(jsonPath("$.location").value("kampus unhas"))
//         .andExpect(jsonPath("$.participants[0].email").value("indra123@gmail.com"));
// }
// }
