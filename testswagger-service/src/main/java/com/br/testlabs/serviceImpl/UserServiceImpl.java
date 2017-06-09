package com.br.testlabs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.testlabs.domain.User;
import com.br.testlabs.repository.UserRepository;
import com.br.testlabs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findOne(long id) {

        return userRepository.findById(id);
    }

    @Override
    public void remove(long id) {
        userRepository.delete(id);
    }

}
