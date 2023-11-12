package com.shoppingWebsite.service;

import com.shoppingWebsite.model.CustomUser;
import com.shoppingWebsite.model.CustomUserRequest;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    void updateUser(CustomUser customUser) throws Exception;
    void deleteUserById(Long id) throws Exception;
    CustomUser getUserById(Long id) throws Exception;
    CustomUser findUserByUsername(String username);
}
