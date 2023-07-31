package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.request.OrderRequest;
import com.cybersoft.cozastore_java21.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;
    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest){
        orderServiceImp.addOrder(orderRequest);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
