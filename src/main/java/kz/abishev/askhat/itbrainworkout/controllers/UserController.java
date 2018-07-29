package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Role;
import kz.abishev.askhat.itbrainworkout.models.User;
import kz.abishev.askhat.itbrainworkout.models.repositories.RoleRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/add")
    public String getRegistrationForm()
    {
        return "add";
    }

    @PostMapping("/add")
    public String registerUser(String username, String password, String password_confirm)
    {
//        User errorUser = new User();
//
//        //no empty fields allowed
//        if (username.isEmpty() || password.isEmpty() || password_confirm.isEmpty()){
//            errorUser.setUsername("No empty fields allowed");
//            return errorUser;
//        }
//
//        //passwords should match
//        if (!password.equals(password_confirm)){
//            errorUser.setUsername("Passwords does not match");
//            return errorUser;
//        }
//
//        //user exists
//        if (userRepository.findByUsername(username) != null){
//            errorUser.setUsername("Such user already exists");
//            return errorUser;
//        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(new Byte("3")).get());
        user.setRoles(roles);
        userRepository.save(user);

        return "redirect:/login";
    }
}
