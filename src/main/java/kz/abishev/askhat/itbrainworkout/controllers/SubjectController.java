package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.Subject;
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
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/{subjectTitle}")
    public String getSubjectPage(@PathVariable String subjectTitle, Model model){
        Subject subject = subjectRepository.findByTitle(subjectTitle);

        List<Question> questions = new ArrayList<>();
        questionRepository.findBySubjectAndStatus(subject, statusRepository.findById(new Byte("1")).get()).forEach(questions::add);

        model.addAttribute("subject", subject);
        model.addAttribute("questionsCount", questions.size());
        return "main/subject";
    }
}
