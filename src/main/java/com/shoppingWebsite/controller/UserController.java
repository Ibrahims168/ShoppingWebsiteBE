package com.shoppingWebsite.controller;

import com.shoppingWebsite.model.CustomUser;
import com.shoppingWebsite.model.CustomUserRequest;
import com.shoppingWebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createUser(@RequestBody CustomUserRequest customUser){
        try{
           userService.createUser(customUser);
           return ResponseEntity.ok("User Signed-up Successfully.");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody CustomUserRequest customUserRequest){
        try {
            userService.updateUser(customUserRequest.toCustomUser());
            return ResponseEntity.ok("User Updated Successfully.");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
          CustomUser customUser = userService.getUserById(id);
          return ResponseEntity.ok(customUser);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try {
            userService.deleteUserById(id);
            return ResponseEntity.ok("User Deleted Successfully.");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}



