package com.shoppingWebsite.repository;

import com.shoppingWebsite.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
    void deleteUserById(Long id);
    CustomUser getUserById(Long id);
    CustomUser findUserByUsername(String username);
}
