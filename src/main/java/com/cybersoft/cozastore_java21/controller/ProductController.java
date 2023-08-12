package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.service.imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    private Gson gson = new Gson();
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id){
        logger.info("tham so"+id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByCategory(id));

        logger.info(gson.toJson(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProduct() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getAllProduct());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByID(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
