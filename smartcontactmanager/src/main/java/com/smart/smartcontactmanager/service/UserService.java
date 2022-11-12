package com.smart.smartcontactmanager.service;

import com.smart.smartcontactmanager.models.User;
import com.smart.smartcontactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;
        public User save(User user){
            return userRepository.save(user);
        }

        public User getUserByUserName(String userName) {
            return userRepository.getUserByUserName(userName);
        }
    }


