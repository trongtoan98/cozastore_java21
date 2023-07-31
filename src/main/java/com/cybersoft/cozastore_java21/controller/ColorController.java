package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.service.imp.ColorServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/color")
@CrossOrigin("*")
public class ColorController {
    private Logger logger = LoggerFactory.getLogger(ColorController.class);
    private Gson gson = new Gson();
    @Autowired
    private ColorServiceImp colorServiceImp;

    @GetMapping()
    public ResponseEntity<?> getAllColor(){
        BaseResponse response = new BaseResponse();
        response.setData(colorServiceImp.getAllColor());
        String data = gson.toJson(response);
        logger.info(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
