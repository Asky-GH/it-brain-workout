package kz.abishev.askhat.itbrainworkout.models.validations;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewQuestionForm {

    @NotBlank(message = "Введите вопрос!")
    private String question;
    @NotBlank(message = "Введите ответ!")
    private String answer1;
    @NotBlank(message = "Введите ответ!")
    private String answer2;
    @NotBlank(message = "Введите ответ!")
    private String answer3;
    @NotBlank(message = "Введите ответ!")
    private String answer4;
}
