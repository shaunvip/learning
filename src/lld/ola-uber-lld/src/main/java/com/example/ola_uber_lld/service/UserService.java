package com.example.ola_uber_lld.service;

import com.example.ola_uber_lld.model.RUser;
import com.example.ola_uber_lld.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Optional<RUser> fetchUser(Long id) {
      return   userRepository.findById(id);
    }

    public List<RUser> findAllUsers() {
       return (List<RUser>) userRepository.findAll();
    }

    public RUser adduser(RUser userInput) {
        log.info("input {}",userInput);
       return userRepository.save(userInput);
    }
}
