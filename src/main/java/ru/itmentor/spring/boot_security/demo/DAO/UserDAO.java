package ru.itmentor.spring.boot_security.demo.DAO;

import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAllUser();

    boolean saveUser(User user);

    void deleteUser(int userId);

    Optional<User> findUserById(int userId);

    void updateUserByIdAndUser(User user, int userId);

    List<String> getRoleInStringById(int id);


}
