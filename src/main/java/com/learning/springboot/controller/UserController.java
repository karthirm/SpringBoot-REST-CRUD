package com.learning.springboot.controller;

import com.learning.springboot.entity.User;
import com.learning.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{userId}")
        public ResponseEntity<User> getUserById(@PathVariable Long userId){
            User getUser = userService.getUserById(userId);
            return ResponseEntity.ok(getUser);
        }

     @GetMapping("/findAll")
        public ResponseEntity<List<User>> getAllUsers(){
            List<User> getUsers = userService.getAllUsers();
            return ResponseEntity.ok(getUsers);
     }

     @PutMapping("/update/{id}")
        public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
     }

     @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return new ResponseEntity<>("user deleted" , HttpStatus.CREATED);
     }
}


