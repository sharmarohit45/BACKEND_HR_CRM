package com.youtube.jwt.service;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("Employee");
        userRole.setRoleDescription("Employee role for default");
        roleDao.save(userRole);
        
        Role clientRole = new Role();
        clientRole.setRoleName("Client");
        clientRole.setRoleDescription("Client role");
        roleDao.save(clientRole);
        

        User adminUser = new User();
        adminUser.setUserName("admin@gmail.com");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
        

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(@RequestBody User user) {
        Set<Role> userRoles = new HashSet<>();

        if ("Employee".equalsIgnoreCase(user.getUserType())) {
            Role role = roleDao.findById("Employee").orElseThrow(() -> new RuntimeException("Role not found"));
            userRoles.add(role);
        } else if ("Client".equalsIgnoreCase(user.getUserType())) {
            Role role = roleDao.findById("Client").orElseThrow(() -> new RuntimeException("Role not found"));
            userRoles.add(role);
        } else {
            throw new RuntimeException("Invalid user type");
        }

        user.setRole(userRoles);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        return userDao.save(user);
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
