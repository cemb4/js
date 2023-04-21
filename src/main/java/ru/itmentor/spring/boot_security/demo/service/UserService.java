package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.DAO.UserDAO;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService extends UserDAO {

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(userRepository, bCryptPasswordEncoder);
    }

    @Override
    public List<User> findAllUser() {
        return super.findAllUser();
    }

    @Override
    public boolean saveUser(User user) {
        return super.saveUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        super.deleteUser(userId);
    }

    @Override
    public Optional<User> findUserById(int userId) {
        return super.findUserById(userId);
    }

    @Override
    public void updateUserByIdAndUser(User user, int userId) {
        super.updateUserByIdAndUser(user, userId);
    }

    @Override
    public List<String> getRoleInStringById(int id) {
        return super.getRoleInStringById(id);
    }
}
