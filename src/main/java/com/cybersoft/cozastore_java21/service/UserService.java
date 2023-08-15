package com.cybersoft.cozastore_java21.service;

import com.cybersoft.cozastore_java21.entity.UserEntity;
import com.cybersoft.cozastore_java21.exception.CustomException;
import com.cybersoft.cozastore_java21.payload.request.SigupRequest;
import com.cybersoft.cozastore_java21.payload.response.UserResponse;
import com.cybersoft.cozastore_java21.repository.UserRepository;
import com.cybersoft.cozastore_java21.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean addUser(SigupRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess = true;

        }catch (Exception e){
            throw new CustomException("lỗi thêm user "+e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        UserResponse userResponse = new UserResponse(user.getId(), user.getEmail(), user.getUsername());
        return userResponse;
    }

}
