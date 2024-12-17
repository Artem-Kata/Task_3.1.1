package ru.bulychev.SpringBoot.Service;


import ru.bulychev.SpringBoot.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User userById(int id);

    void update(int id, User updatedUser);

    void delete(int id);
}