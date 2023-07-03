package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.exception.CustomException;
import com.cybersoft.cozastore_java21.payload.request.SigupRequest;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.service.imp.UserServiceImp;
import com.cybersoft.cozastore_java21.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserServiceImp userServiceImp;
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> signin(
            @RequestParam String email,@RequestParam String password
    ){
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
            authenticationManager.authenticate(token);
            //        nếu chứng thực thành công sẽ chạy code tiếp theo
            //        còn nếu thất bại sẽ văng lõi chưa chứng thực
            //        sau khi chứng thực thành công trả ra token
            //        token tuyệt đối không được lưu trữ passowrd
            //        trả ra theo cấu trúc statusCode, message,data
            String jwt = jwtHelper.generateToken(email);
            BaseResponse response = new BaseResponse();
            response.setStatusCode(200);
            response.setData(jwt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SigupRequest request, BindingResult result) {
        List<FieldError> list = result.getFieldErrors();
        for(FieldError data : list){
            throw new CustomException(data.getDefaultMessage());
//            System.out.println("kiem tra"+ data.getField()+"-"+data.getDefaultMessage());
        }
        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
