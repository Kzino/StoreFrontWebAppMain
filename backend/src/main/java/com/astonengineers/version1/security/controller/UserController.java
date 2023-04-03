package com.astonengineers.version1.security.controller;


import com.astonengineers.version1.security.dto.LoginDTO;
import com.astonengineers.version1.security.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/user")
public class UserController {

//    @PostMapping(path="/save")
//    public String saveUser(@RequestBody UserDTO userDTO) {
//        String UserID = userService.addUser(userDTO);
//        return UserID;
//    }

//    @PostMapping(path="/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
//        LoginResponse loginResponse = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }
}
