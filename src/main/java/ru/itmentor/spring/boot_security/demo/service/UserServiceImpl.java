package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.DAO.UserDAO;
import ru.itmentor.spring.boot_security.demo.DAO.UserDAOImpl;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl {

//    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ) {
//        super(userRepository, bCryptPasswordEncoder);
//    }
private final UserDAO userDAO;
private final BCryptPasswordEncoder bCryptPasswordEncoder;

public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserDAO userDAO){
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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


//    public List<String> getRoleInStringById(int id) {
//        return userDAO.getRoleInStringById(id);
//    }
}
