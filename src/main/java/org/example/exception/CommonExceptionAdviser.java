package org.example.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionAdviser {
    private static final Logger LOG = LoggerFactory.getLogger(CommonExceptionAdviser.class);

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void userNotFound(Exception e) {
        LOG.error(e.getMessage());
    }
}
