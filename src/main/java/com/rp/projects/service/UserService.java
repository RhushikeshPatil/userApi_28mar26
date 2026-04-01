package com.rp.projects.service;

import com.rp.projects.dto.UserRequest;
import com.rp.projects.model.User;

import java.util.List;

public interface UserService {

    User createUser(UserRequest userRequest);

    List<User>  getAllUsers();

    User getUserById (Long Id );

    User updateUser(Long id , UserRequest request);

    void deleteUser(Long id );


}
