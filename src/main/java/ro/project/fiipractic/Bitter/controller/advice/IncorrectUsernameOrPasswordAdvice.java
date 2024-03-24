package ro.project.fiipractic.Bitter.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.project.fiipractic.Bitter.exception.IncorrectUsernameOrPasswordException;
import ro.project.fiipractic.Bitter.exception.UserNotFoundException;

@ControllerAdvice
public class IncorrectUsernameOrPasswordAdvice {
    @ResponseBody
    @ExceptionHandler(IncorrectUsernameOrPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userNotFoundHandler(IncorrectUsernameOrPasswordException ex)
    {
        return ex.getMessage();
    }
}
