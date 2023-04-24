package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.DAO.UserDAO;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl {


    private final UserDAO userDAO;


    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }


    public boolean saveUser(User user) {
        return userDAO.saveUser(user);
    }


    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }


    public Optional<User> findUserById(int userId) {
        return userDAO.findUserById(userId);
    }


    public void updateUserByIdAndUser(User user, int userId) {
        userDAO.updateUserByIdAndUser(user, userId);
    }


}
