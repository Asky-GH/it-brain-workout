package kz.abishev.askhat.itbrainworkout.controllers;

import kz.abishev.askhat.itbrainworkout.models.Answer;
import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.repositories.*;
import kz.abishev.askhat.itbrainworkout.models.validations.NewQuestionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/{subjectTitle}/new")
    public String getNewQuestionForm(@PathVariable String subjectTitle, Model model, NewQuestionForm newQuestionForm){
        model.addAttribute("subjectTitle", subjectTitle);
        return "supplement/new-question";
    }

    @PostMapping("/{subjectTitle}/new")
    public String createQuestion(@Valid NewQuestionForm newQuestionForm, BindingResult bindingResult, @PathVariable String subjectTitle, @RequestParam String answers){
        if (bindingResult.hasErrors()){
            return "supplement/new-question";
        }

        Set<String> answersBodies = new HashSet<>();
        answersBodies.add(newQuestionForm.getAnswer1());
        answersBodies.add(newQuestionForm.getAnswer2());
        answersBodies.add(newQuestionForm.getAnswer3());
        answersBodies.add(newQuestionForm.getAnswer4());
        if (answersBodies.size() != 4){
            bindingResult.addError(new ObjectError("newQuestionForm", "Ответы должны быть разными!"));
            return "supplement/new-question";
        }

        Question question = new Question();
        question.setBody(newQuestionForm.getQuestion());
        question.setSubject(subjectRepository.findByTitle(subjectTitle));
        question.setStatus(statusRepository.findById(new Byte("2")).get());
        String rightAnswer = null;
        switch (answers){
            case "answer1":
                rightAnswer = newQuestionForm.getAnswer1();
                break;
            case "answer2":
                rightAnswer = newQuestionForm.getAnswer2();
                break;
            case "answer3":
                rightAnswer = newQuestionForm.getAnswer3();
                break;
            case "answer4":
                rightAnswer = newQuestionForm.getAnswer4();
                break;
        }
        for (String answerBody : answersBodies){
            Answer answer = new Answer();
            answer.setBody(answerBody);
            if (answerBody.equals(rightAnswer)){
                answer.setType(typeRepository.findById(new Byte("1")).get());
            }
            else {
                answer.setType(typeRepository.findById(new Byte("2")).get());
            }
            question.getAnswers().add(answer);
        }
        questionRepository.save(question);

        return "redirect:/subjects/" + subjectTitle + "?success";
    }

    @GetMapping("/{subjectTitle}/pending")
    public String getPendingQuestion(@PathVariable String subjectTitle, Model model){
        List<Question> pendingQuestions = new ArrayList<>();
        questionRepository.findBySubjectAndStatus(subjectRepository.findByTitle(subjectTitle), statusRepository.findById(new Byte("2")).get()).forEach(pendingQuestions::add);
        model.addAttribute("question", pendingQuestions.get(0));
        return "supplement/pending-question";
    }

    @PostMapping("/{subjectTitle}/pending")
    public String processPendingQuestion(@RequestParam String action, @RequestParam String questionId){
        Question question = questionRepository.findById(Long.parseLong(questionId)).get();

        if (action.equals("Отклонить")){
            questionRepository.delete(question);
        }
        else {
            question.setStatus(statusRepository.findById(new Byte("1")).get());
            questionRepository.save(question);
        }

        return "redirect:/";
    }
}
