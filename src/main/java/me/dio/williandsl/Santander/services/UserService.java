package me.dio.williandsl.Santander.services;

import me.dio.williandsl.Santander.model.User;

public interface UserService {
    User findById (Long id);

    User create (User userToCreate) throws IllegalAccessException;
}
