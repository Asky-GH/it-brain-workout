package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.Subject;
import kz.abishev.askhat.itbrainworkout.models.repositories.SubjectRepository;
import kz.abishev.askhat.itbrainworkout.utils.HelperMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/{subjectTitle}")
    public String getSubjectPage(@PathVariable String subjectTitle, Model model, HttpServletRequest request){
        List<Question> questions = HelperMethods.getTestQuestions(subjectTitle, request, null);

        model.addAttribute("subjectTitle", subjectTitle);
        model.addAttribute("questions", questions);
        return "main/subject";
    }

    @GetMapping("/new")
    public String getNewSubjectForm(){
        return "supplement/new-subject";
    }

    @PostMapping("/new")
    public String createSubject(@RequestParam String subjectTitle){
        Subject subject = new Subject();
        subject.setTitle(subjectTitle);
        subjectRepository.save(subject);
        return "redirect:/";
    }
}
