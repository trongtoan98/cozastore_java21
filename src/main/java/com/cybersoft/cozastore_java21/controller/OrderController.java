package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.request.OrderRequest;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.payload.response.OrderResponse;
import com.cybersoft.cozastore_java21.service.imp.OrderServiceImp;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@RequestBody OrderRequest orderRequest){
        orderServiceImp.addOrder(orderRequest);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @RequestMapping(value = "getOrder/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getOrderByUserId(@PathVariable int id){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(orderServiceImp.getOrderByUserId(id));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
