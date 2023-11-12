package com.shoppingWebsite.service;

import com.shoppingWebsite.model.CustomUser;
import com.shoppingWebsite.model.CustomUserRequest;
import com.shoppingWebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public void updateUser(CustomUser customUser) throws Exception {
        Long userId = customUser.getId();
        CustomUser existingUser = userRepository.getUserById(userId);
        if (existingUser != null) {
            userRepository.updateUser(customUser);
        } else {
            throw new Exception("User with ID " + userId + " does not exist");
        }
    }

    @Override
    public void deleteUserById(Long id) throws Exception {
        CustomUser user = userRepository.getUserById(id);
        if (user != null) {
            userRepository.deleteUserById(id);
        } else {
            throw new Exception("User ID: "+ id + " Does Not Exist") ;
        }
    }

    @Override
    public CustomUser getUserById(Long id) throws Exception{
        CustomUser user = userRepository.getUserById(id);
        if (user != null) {
            return userRepository.getUserById(id);
        } else {
            throw new Exception("User ID: "+ id + " Does Not Exist") ;
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}





