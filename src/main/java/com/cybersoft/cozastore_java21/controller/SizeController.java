package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
@CrossOrigin("*")
public class SizeController {
    @Autowired
    private SizeServiceImp sizeServiceImp;
    @GetMapping()
    public ResponseEntity<?> getAllSize(){
        BaseResponse response = new BaseResponse();
        response.setData(sizeServiceImp.getAllSize());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
