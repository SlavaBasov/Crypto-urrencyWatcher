package com.basovProjects.cryptoCurrencyWatcher.aop;

import com.basovProjects.cryptoCurrencyWatcher.controller.CryptocurrencyController;
import com.basovProjects.cryptoCurrencyWatcher.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final CryptocurrencyController cryptocurrencyController;

    @Autowired
    public ExceptionHandlerAdvice(CryptocurrencyController cryptocurrencyController) {
        this.cryptocurrencyController = cryptocurrencyController;
    }

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity myObjectNotFoundExceptionHandler(Exception ex)  {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setError(ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

}
