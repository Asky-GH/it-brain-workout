package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Progress;
import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.Subject;
import kz.abishev.askhat.itbrainworkout.models.User;
import kz.abishev.askhat.itbrainworkout.models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StatusRepository statusRepository;

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

    @GetMapping("/{username}")
    public String getProfile(@PathVariable String username, Model model){
        List<String[]> data = new ArrayList<>();

        User user = userRepository.findByUsername(username);

        List<Subject> subjects = new ArrayList<>();
        subjectRepository.findAll().forEach(subjects::add);

        for (Subject subject : subjects){
            List<Progress> progresses = new ArrayList<>();
            progressRepository.findByUserAndSubject(user, subject).forEach(progresses::add);
            int solvedQuestions = 0;

            for (Progress progress : progresses){
                if (progress.getResult().getTitle().equals("CORRECT")){
                    solvedQuestions++;
                }
            }

            List<Question> totalQuestions = new ArrayList<>();
            questionRepository.findBySubjectAndStatus(subject, statusRepository.findById(new Byte("1")).get()).forEach(totalQuestions::add);
            if (totalQuestions.size() > 0){
                data.add(new String[]{subject.getTitle(), String.valueOf(solvedQuestions), String.valueOf(totalQuestions.size())});
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("data", data);
        return "supplement/profile";
    }

    @PostMapping("/{username}")
    public String changePassword(@PathVariable String username, @RequestParam String action, @RequestParam String password, @RequestParam String confirm, @RequestParam String subjectTitle){
        if (action.equals("Изменить")){
            if (password == null || password.trim().isEmpty() || password.trim().length() < 6){
                return "redirect:/users/" + username + "/?password";
            }

            if (!password.equals(confirm)){
                return "redirect:/users/" + username + "/?confirm";
            }

            User user = userRepository.findByUsername(username);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            userRepository.save(user);

            return "redirect:/users/" + username + "/?success";
        }
        else {
            List<Progress> progresses = new ArrayList<>();
            progressRepository.findByUserAndSubject(userRepository.findByUsername(username), subjectRepository.findByTitle(subjectTitle)).forEach(progresses::add);
            for (Progress progress : progresses){
                progressRepository.delete(progress);
            }

            return "redirect:/users/" + username;
        }
    }
}
