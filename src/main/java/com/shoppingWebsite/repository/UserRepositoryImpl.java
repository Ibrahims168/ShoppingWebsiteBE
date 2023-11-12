package com.shoppingWebsite.repository;

import com.shoppingWebsite.model.CustomUser;
import com.shoppingWebsite.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (first_name, last_name, email, phone_number, address, username, password) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                customUser.getFirstName(),
                customUser.getLastName(),
                customUser.getEmail(),
                customUser.getPhoneNumber(),
                customUser.getAddress(),
                customUser.getUsername(),
                customUser.getPassword()
        );
    }

    @Override
    public void updateUser(CustomUser customUser) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone_number=?, address=?, username=?, password=? WHERE id=?";
        jdbcTemplate.update(
                sql,
                customUser.getFirstName(),
                customUser.getLastName(),
                customUser.getEmail(),
                customUser.getPhoneNumber(),
                customUser.getAddress(),
                customUser.getUsername(),
                customUser.getPassword(),
                customUser.getId()
        );
    }

    @Override
    public void deleteUserById(Long id) {
        String sql = "DELETE " + USER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public CustomUser getUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}


