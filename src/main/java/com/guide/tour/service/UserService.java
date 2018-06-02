package com.guide.tour.service;

import com.guide.tour.model.User;
import com.guide.tour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //services
    public User findUserById(long id) {
        return userRepository.findById(id);
    }
    public void changeUsernameByiD(long id, String name){
        userRepository.findById(id).setName(name);
    }
}
