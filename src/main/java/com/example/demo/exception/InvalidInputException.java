package com.example.demo.exception;

/**
 * Invalid Input exception
 * Thrown when the input is missing or invalid
 *
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String msg) {
        super(msg);
    }
}
