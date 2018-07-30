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

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/registration")
    public String getRegistrationForm(RegistrationForm registrationForm)
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid RegistrationForm registrationForm, BindingResult bindingResult)
    {
        if (userRepository.findByUsername(registrationForm.getUsername()) != null){
            bindingResult.addError(new ObjectError("registrationForm", "Имя пользователя уже существует!"));
            return "registration";
        }

        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirm())){
            bindingResult.addError(new ObjectError("registrationForm", "Пароли не совпадают!"));
            return "registration";
        }

        if (bindingResult.hasErrors()){
            return "registration";
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
