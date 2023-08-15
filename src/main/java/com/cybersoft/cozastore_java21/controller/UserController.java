package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.exception.CustomException;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.payload.response.UserResponse;
import com.cybersoft.cozastore_java21.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        UserResponse userResponse = userServiceImp.getUserByEmail(email);
        BaseResponse response = new BaseResponse();
        if(userResponse !=null){
            response.setStatusCode(200);
            response.setData(userResponse);
        }else {
            throw new CustomException("Not found");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
