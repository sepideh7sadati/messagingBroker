package com.company.soha.tejarat.messaging.services;

import com.company.soha.tejarat.messaging.dto.UserDto;
import com.company.soha.tejarat.messaging.model.User;
import com.company.soha.tejarat.messaging.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        return userRepository.save(user);
    }
}
