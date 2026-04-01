package com.rp.projects.service;

import com.rp.projects.dto.UserRequest;
import com.rp.projects.exceptions.DuplicateUserException;
import com.rp.projects.exceptions.ResourceNotFoundException;
import com.rp.projects.model.User;
import com.rp.projects.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserRepository repository ;


    @Override
    public User createUser(UserRequest request) {
     if(repository.findByEmail(request.getEmail()).isPresent()){
         throw new DuplicateUserException("Email Already Exist");

     }
     User user = new User();
     user.setName(request.getName());
     user.setEmail(request.getEmail());
     user.setAge(request.getAge());
     user.setCity(request.getCity());
     user.setGender(request.getGender());

     return repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {


        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        Optional<User>  user = repository.findById(id);

        if(!user.isPresent()){
            throw  new ResourceNotFoundException("User not Registered with id : " + id );

        }


        return user.get();
    }

    @Override
    public User updateUser(Long id, UserRequest request) {


//        Optional<User>  user = repository.findById(id);
        User existingUser = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not registered with id : " + id));


        Optional<User>  userwithemail = repository.findByEmail(request.getEmail());


        if(userwithemail.isPresent() && !userwithemail.get().getId().equals(id)){
            throw  new DuplicateUserException("Email already exists for a different user , please use different email !");
        }

//        if(!existingUser.isPresent()){
//            throw new ResourceNotFoundException("User not registered with id : " + id );
//        }

//        if(repository.findByEmail(request.getEmail()).isPresent()){
//            throw  new DuplicateUserException("Email already exists , Use different email . ");
//
//        }

        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());
        existingUser.setAge(request.getAge());
        existingUser.setCity(request.getCity());
        existingUser.setGender(request.getGender());

        return repository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {

        User user = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with ID : " + id ));


         repository.delete(user);
    }
}
