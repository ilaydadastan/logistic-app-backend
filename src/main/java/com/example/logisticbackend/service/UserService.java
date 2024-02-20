package com.example.logisticbackend.service;

import com.example.logisticbackend.dto.UserCreateRequestVM;
import com.example.logisticbackend.model.User;
import com.example.logisticbackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User findUserByUsername (String username){
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public User createUser(UserCreateRequestVM userCreateRequestVM){
        if (userRepository.findByUsername(userCreateRequestVM.getUsername()).isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        User user = new User(null, userCreateRequestVM.getUsername(),
                passwordEncoder.encode(userCreateRequestVM.getPassword()),
                userCreateRequestVM.getFirstname(),
                userCreateRequestVM.getLastname(),
                userCreateRequestVM.getEmail());
        return userRepository.save(user);
    }
}
