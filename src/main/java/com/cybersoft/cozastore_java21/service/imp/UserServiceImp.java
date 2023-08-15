package com.cybersoft.cozastore_java21.service.imp;

import com.cybersoft.cozastore_java21.payload.request.SigupRequest;
import com.cybersoft.cozastore_java21.payload.response.UserResponse;

public interface UserServiceImp {
    boolean addUser(SigupRequest request);
    UserResponse getUserByEmail(String email);
}
