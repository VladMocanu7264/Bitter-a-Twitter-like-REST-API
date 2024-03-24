package ro.project.fiipractic.Bitter.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.project.fiipractic.Bitter.exception.NotLoggedInException;
import ro.project.fiipractic.Bitter.exception.UserNotFoundException;

@ControllerAdvice
public class NotLoggedInAdvice {

    @ResponseBody
    @ExceptionHandler(NotLoggedInException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String NotLoggedInHandler(NotLoggedInException ex) {
        return ex.getMessage();
    }
}
