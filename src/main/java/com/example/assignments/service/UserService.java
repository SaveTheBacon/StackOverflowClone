package com.example.assignments.service;



import com.example.assignments.model.User;
import com.example.assignments.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    IUserRepository iUserRepository;

    public List<User> getAllUsers(){
        return (List<User>) iUserRepository.findAll();
    }

    public User getUser(Integer ID){
        Optional<User> user = iUserRepository.findById(ID);
        return user.orElse(null);
    }

    public String deleteUser(Integer ID){
        try{
            iUserRepository.delete(this.getUser(ID));
            return "Delete successful";
        }
        catch (Exception e){
            return "Deletion failed";
        }
    }

    public User saveUser(User user){
        return iUserRepository.save(user);
    }

    public User updateUser(Integer id, User user){
        User initialUser = this.getUser(id);
        return iUserRepository.save(initialUser);
    }


}
