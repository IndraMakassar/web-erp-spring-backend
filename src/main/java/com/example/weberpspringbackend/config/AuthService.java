package com.example.weberpspringbackend.config;

import com.example.weberpspringbackend.model.AuthenticationRequest;
import com.example.weberpspringbackend.model.AuthenticationResponse;
import com.example.weberpspringbackend.model.RegisterRequest;
import com.example.weberpspringbackend.model.entity.Role;
import com.example.weberpspringbackend.model.entity.User;
import com.example.weberpspringbackend.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .nama(request.getNama())
                .email(request.getEmail())
                .department(request.getDepartment())
                .position(request.getPosition())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        var jwtToken = JwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        var jwtToken = JwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
