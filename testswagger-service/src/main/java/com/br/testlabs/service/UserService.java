package com.br.testlabs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.testlabs.domain.User;

@Service
public interface UserService {
    
    void save(User user);
    
    List<User> findAll();
    
    User findOne(long id);
    
    void remove(long id);

}
