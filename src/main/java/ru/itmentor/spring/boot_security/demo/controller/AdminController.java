package ru.itmentor.spring.boot_security.demo.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;
import ru.itmentor.spring.boot_security.demo.security.UserDetail;
import ru.itmentor.spring.boot_security.demo.service.UserServiceImpl;

import java.util.List;

@RestController
public class AdminController {
    private final UserServiceImpl userService;
    private final RoleRepository roleRepository;


    public AdminController(UserServiceImpl userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @GetMapping("/admin/all")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/admin/user")
    public User getUser(Authentication authentication) {
        UserDetail user =(UserDetail)authentication.getPrincipal();
        return user.getUser();
    }

    @GetMapping("/admin/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id).orElse(null);
    }

    @GetMapping("/admin/roles")
    public List<Role> getUserById(){
        return roleRepository.findAll();
    }

    @PatchMapping("/admin/edit/{id}")
    public User editUser(@RequestBody User editUser,
                          @PathVariable("id") Integer id){
        userService.updateUserByIdAndUser(editUser,id);
        return userService.findUserById(id).orElse(null);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    @PostMapping("/admin/save")
    public User saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/user/this")
    public User getAuthUser(Authentication authentication) {
        UserDetail user =(UserDetail)authentication.getPrincipal();
        return user.getUser();
    }
}