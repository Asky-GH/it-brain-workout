package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.*;
import kz.abishev.askhat.itbrainworkout.models.repositories.*;
import kz.abishev.askhat.itbrainworkout.utils.HelperMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String getMainPage(Model model){
        model.addAttribute("subjects", subjectRepository.findAll());
        return "main/main";
    }

    @GetMapping("{subjectTitle}/test")
    public String getTest(@PathVariable String subjectTitle, Model model, @RequestParam String quantity, HttpServletRequest request){
        List<Question> questions = HelperMethods.getTestQuestions(subjectTitle, request, quantity);

        model.addAttribute("subjectTitle", subjectTitle);
        model.addAttribute("questions", questions);
        return "main/test";
    }

    @PostMapping("{subjectTitle}/test")
    public String postTest(@PathVariable String subjectTitle, @RequestParam String quantity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        List<Question> questions = HelperMethods.getTestQuestions(subjectTitle, request, quantity);
        String username = request.getRemoteUser();
        User user = new User();

        if (username != null){
            user = userRepository.findByUsername(username);
        }
        else {
            user = null;
        }

        List<String[]> results = new ArrayList<>();
        for (Question question : questions){
            for (Answer answer : question.getAnswers()){
                if (Long.toString(answer.getId()).equals(request.getParameter(Long.toString(question.getId())))){
                    if (answer.getType().getTitle().equals("RIGHT")){
                        results.add(new String[]{question.getBody(), "ВЕРНО"});
                        if (user != null){
                            HelperMethods.saveProgress(user, subjectTitle, question, "1");
                        }
                    }
                    else {
                        results.add(new String[]{question.getBody(), "НЕВЕРНО"});
                        if (user != null){
                            HelperMethods.saveProgress(user, subjectTitle, question, "2");
                        }
                    }
                }
            }
        }

        redirectAttributes.addFlashAttribute("results", results);
        return "redirect:/result";
    }

    @GetMapping("result")
    public String getResult(){
        return "main/result";
    }
}
