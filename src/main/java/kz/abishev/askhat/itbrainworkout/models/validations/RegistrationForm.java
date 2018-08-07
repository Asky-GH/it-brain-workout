package kz.abishev.askhat.itbrainworkout.models.validations;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {

    @NotBlank(message = "Введите имя пользователя!")
    @Size(min = 2, max = 255, message = "Имя пользователя не должно быть меньше 2 символов!")
    private String username;
    @NotBlank(message = "Введите пароль!")
    @Size(min = 6, max = 255, message = "Пароль не должен быть меньше 6 символов!")
    private String password;
    private String password_confirm;

    public String getPasswordConfirm(){
        return password_confirm;
    }
}
