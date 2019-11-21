package com.dreamteam.parkshark.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler({IllegalArgumentException.class,NullPointerException.class})
    protected void handler(RuntimeException exception,
                           HttpServletResponse response)
            throws IOException {
        logger.warn(exception.getMessage());
        logger.info(Arrays.toString(exception.getStackTrace()));
        response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                exception.getMessage());
    }

}
