package ru.itmentor.spring.boot_security.demo.DAO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
public class UserDAOImpl implements UserDAO{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDAOImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Transactional
    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getName());

        if (!userFromDB.isEmpty()) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(2, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Transactional
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }


    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public void updateUserByIdAndUser(User user, int userId) {
        user.setId(userId);
        userRepository.save(user);
    }

    public List<String> getRoleInStringById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.isEmpty() ? null : user.get().getRoles().stream().map(role -> role.getName()).collect(Collectors.toList());

    }
}
