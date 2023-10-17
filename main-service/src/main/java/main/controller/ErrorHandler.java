package main.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorApi handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
            HttpStatus status) {
        log.info("400 {}", exception.getMessage());
        return new ErrorApi(status, "Не валидно", exception.getMessage(), Collections.emptyList());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorApi handleException(Exception exception,
            HttpStatus status) {
        log.error("Error", exception);
        StringWriter out = new StringWriter();
        exception.printStackTrace(new PrintWriter(out));
        String stackTrace = out.toString();
        return new ErrorApi(status, "Что-то пошло не так", exception.getMessage(), Collections.singletonList(stackTrace));
    }
}
