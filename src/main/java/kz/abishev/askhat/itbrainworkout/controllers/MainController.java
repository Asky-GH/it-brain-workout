package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.repositories.QuestionRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.StatusRepository;
import kz.abishev.askhat.itbrainworkout.models.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("")
    public String getMainPage(Model model){
        model.addAttribute("subjects", subjectRepository.findAll());
        return "main/main";
    }

    @GetMapping("{subjectTitle}/test")
    public String getTest(@PathVariable String subjectTitle, Model model){
        List<Question> questions = new ArrayList<>();
        questionRepository.findBySubjectAndStatus(subjectRepository.findByTitle(subjectTitle), statusRepository.findById(new Byte("1")).get()).forEach(questions::add);

        model.addAttribute("subjectTitle", subjectTitle);
        model.addAttribute("questions", questions);
        return "main/test";
    }
}
