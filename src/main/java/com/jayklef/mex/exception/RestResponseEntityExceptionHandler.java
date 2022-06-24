package com.jayklef.mex.exception;

import com.jayklef.mex.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ResponseStatus
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<ErrorMessage> BillNotFoundException(BillNotFoundException exception,
                                                              WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(AmenitiesNotFoundException.class)
    public ResponseEntity<ErrorMessage> AmenitiesNotFoundException(AmenitiesNotFoundException exception,
                                                                   WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(ResidentNotFoundException.class)
    public ResponseEntity<ErrorMessage> ResidentNotFoundException(ResidentNotFoundException exception,
                                                                  WebRequest request){
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorMessage> CategoryNotFoundException(CategoryNotFoundException exception,
                                                                  WebRequest request) {
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }


    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorMessage> HouseNotFoundException(HouseNotFoundException exception,
                                                                  WebRequest request) {
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> AccountNotFoundException(AccountNotFoundException exception,
                                                               WebRequest request) {
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setStatus(HttpStatus.NOT_FOUND.toString());
        message.setError(message.getError());
        message.setMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }
}
