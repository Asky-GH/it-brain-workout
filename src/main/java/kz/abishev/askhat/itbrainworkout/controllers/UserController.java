package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Progress;
import kz.abishev.askhat.itbrainworkout.models.User;
import kz.abishev.askhat.itbrainworkout.models.repositories.ProgressRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.RoleRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ProgressRepository progressRepository;

    @GetMapping("")
    public String getUsers(Model model){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        model.addAttribute("users", users);
        model.addAttribute("roleAdmin", roleRepository.findById(new Byte("1")).get());
        model.addAttribute("roleModer", roleRepository.findById(new Byte("2")).get());
        return "supplement/users";
    }

    @PostMapping("")
    public String manageUsers(@RequestParam String action, @RequestParam String username){
        User user = userRepository.findByUsername(username);

        switch (action){
            case "grantAdmin":
                user.getRoles().add(roleRepository.findById(new Byte("1")).get());
                break;
            case "removeAdmin":
                user.getRoles().remove(roleRepository.findById(new Byte("1")).get());
                break;
            case "grantModer":
                user.getRoles().add(roleRepository.findById(new Byte("2")).get());
                break;
            case "removeModer":
                user.getRoles().remove(roleRepository.findById(new Byte("2")).get());
                break;
            case "removeUser":
                for (Progress progress : progressRepository.findByUser(user)){
                    progressRepository.delete(progress);
                }
                userRepository.delete(user);
                return "redirect:/users";
        }

        userRepository.save(user);
        return "redirect:/users";
    }
}
