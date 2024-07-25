package me.dio.williandsl.Santander.services.impl;

import me.dio.williandsl.Santander.model.User;
import me.dio.williandsl.Santander.repository.UserRepository;
import me.dio.williandsl.Santander.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) throws IllegalAccessException {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalAccessException("This account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
