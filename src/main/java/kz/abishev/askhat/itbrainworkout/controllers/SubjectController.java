package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.utils.HelperMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @GetMapping("/{subjectTitle}")
    public String getSubjectPage(@PathVariable String subjectTitle, Model model, HttpServletRequest request){
        List<Question> questions = HelperMethods.getTestQuestions(subjectTitle, request, null);

        model.addAttribute("subjectTitle", subjectTitle);
        model.addAttribute("questions", questions);
        return "main/subject";
    }
}
