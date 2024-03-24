package ro.project.fiipractic.Bitter.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.project.fiipractic.Bitter.exception.UsernameAlreadyInUseException;

public class UsernameAlreadyInUseAdvice {

    @ResponseBody
    @ExceptionHandler(UsernameAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String UsernameAlreadyInUseHandler(UsernameAlreadyInUseException ex)
    {
        return ex.getMessage();
    }

}
