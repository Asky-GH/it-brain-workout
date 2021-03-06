package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Role;
import kz.abishev.askhat.itbrainworkout.models.User;
import kz.abishev.askhat.itbrainworkout.models.repositories.RoleRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.UserRepository;
import kz.abishev.askhat.itbrainworkout.models.validations.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/registration")
    public String getRegistrationPage(RegistrationForm registrationForm)
    {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String createUser(@Valid RegistrationForm registrationForm, BindingResult bindingResult)
    {
        if (userRepository.findByUsername(registrationForm.getUsername()) != null){
            bindingResult.addError(new ObjectError("registrationForm", "Имя пользователя уже существует!"));
            return "auth/registration";
        }

        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirm())){
            bindingResult.addError(new ObjectError("registrationForm", "Пароли не совпадают!"));
            return "auth/registration";
        }

        if (bindingResult.hasErrors()){
            return "auth/registration";
        }

        User user = new User();
        user.setUsername(registrationForm.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(registrationForm.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(new Byte("3")).get());
        user.setRoles(roles);
        userRepository.save(user);

        return "redirect:/login?success";
    }
}
