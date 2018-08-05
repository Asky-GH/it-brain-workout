package kz.abishev.askhat.itbrainworkout.utils;

import kz.abishev.askhat.itbrainworkout.models.Progress;
import kz.abishev.askhat.itbrainworkout.models.Question;
import kz.abishev.askhat.itbrainworkout.models.Subject;
import kz.abishev.askhat.itbrainworkout.models.User;
import kz.abishev.askhat.itbrainworkout.models.repositories.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelperMethods {

    private static SubjectRepository subjectRepository;
    private static QuestionRepository questionRepository;
    private static StatusRepository statusRepository;
    private static ProgressRepository progressRepository;
    private static UserRepository userRepository;
    private static ResultRepository resultRepository;

    public HelperMethods(SubjectRepository subjectRepository, QuestionRepository questionRepository, StatusRepository statusRepository, ProgressRepository progressRepository, UserRepository userRepository, ResultRepository resultRepository){
        HelperMethods.subjectRepository = subjectRepository;
        HelperMethods.questionRepository = questionRepository;
        HelperMethods.statusRepository = statusRepository;
        HelperMethods.progressRepository = progressRepository;
        HelperMethods.userRepository = userRepository;
        HelperMethods.resultRepository = resultRepository;
    }

    public static List<Question> getTestQuestions(String subjectTitle, HttpServletRequest request, String quantity) {
        List<Question> questions = new ArrayList<>();
        List<Question> totalQuestions = new ArrayList<>();
        questionRepository.findBySubjectAndStatus(subjectRepository.findByTitle(subjectTitle), statusRepository.findById(new Byte("1")).get()).forEach(totalQuestions::add);
        String username = request.getRemoteUser();
        int count = 1;

        if (username != null){
            User user = userRepository.findByUsername(username);
            Subject subject = subjectRepository.findByTitle(subjectTitle);
            List<Progress> progresses = new ArrayList<>();
            progressRepository.findByUserAndSubject(user, subject).forEach(progresses::add);

            if (progresses.size() != 0){
                for (Question question : totalQuestions){
                    boolean solved = false;
                    for (Progress progress : progresses){
                        if (progress.getQuestion().getId() == question.getId() && progress.getResult().getTitle().equals("CORRECT")){
                            solved = true;
                        }
                    }
                    if (!solved){
                        questions.add(question);
                        if (quantity != null && count == Integer.parseInt(quantity)){
                            break;
                        }
                        count++;
                    }
                }

                return questions;
            }
        }

        for (Question question : totalQuestions){
            questions.add(question);
            if (quantity != null && count == Integer.parseInt(quantity)){
                break;
            }
            count++;
        }

        return questions;
    }

    public static void saveProgress(User user, String subjectTitle, Question question, String resultId) {
        Progress progress = new Progress();
        progress.setUser(user);
        progress.setSubject(subjectRepository.findByTitle(subjectTitle));
        progress.setQuestion(question);
        progress.setResult(resultRepository.findById(new Byte(resultId)).get());
        progressRepository.save(progress);
    }

}
