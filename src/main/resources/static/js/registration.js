$(document).ready(function() {
    if ($("#global").length){
        if ($("#global").text() == "Имя пользователя уже существует!"){
            $("#username").addClass("is-danger");
            $("#usernameControl").append("<span class='icon is-small is-right'><i class='fas fa-exclamation-triangle'></i></span>");
        }
        else {
            $("#password").addClass("is-danger");
            $("#passwordControl").append("<span class='icon is-small is-right'><i class='fas fa-exclamation-triangle'></i></span>");
            $("#confirm").addClass("is-danger");
            $("#confirmControl").append("<span class='icon is-small is-right'><i class='fas fa-exclamation-triangle'></i></span>");
        }
    }
});