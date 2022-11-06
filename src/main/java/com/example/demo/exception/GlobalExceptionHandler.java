package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.*;

import static com.example.demo.util.Constants.*;

/**
 * Global exception handler that provides meaningful errors messages to the invoker
 * Returns appropriate HTTP status code and message
 * Logs error details to the console
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles missing input parameters
     *
     * @param ex - Exception
     * @param headers - HTTP headers
     * @param status - HTTP status
     * @param request - Input request
     * @return ResponseEntity with error details
     *
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        String error = "Parameter '" + ex.getParameterName() + "' is missing in the request";
        LOGGER.error(error);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles exceptions for invalid data, system and application errors
     *
     * @param ex - Exception
     * @param request - HTTP request
     * @param response - HTTP response
     * @return ResponseEntity with error details
     *
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex,
                                         HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof MissingServletRequestParameterException) {
            LOGGER.error(MISSING_INPUT_MESSAGE);
            return new ResponseEntity<>(MISSING_COUNT_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        if (ex instanceof InvalidInputException) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
