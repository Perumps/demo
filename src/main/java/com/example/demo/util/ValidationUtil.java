package com.example.demo.util;

import com.example.demo.exception.InvalidInputException;
import org.apache.commons.lang3.StringUtils;

import static com.example.demo.util.Constants.*;

/**
 * Validation utility that checks for missing or invalid inputs
 *
 */
public class ValidationUtil {

    /**
     * Validates input Count
     * Throws an exception when Count is non-integer
     *
     * @param count - Count parameter from the input
     * @throws InvalidInputException Invalid Input Exception
     *
     */
    public static void validateCount(String count) throws InvalidInputException {

        try {
            if (count == null || count.isBlank() || count.isEmpty() || (Integer.parseInt(count) <= 0)) {
                throw new InvalidInputException(INVALID_COUNT_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(INVALID_COUNT_MESSAGE);
        }

    }

    /**
     * Validates input array
     * Throws an exception when input array is empty or contains non-numeric content
     *
     * @param inputArray - Count parameter from the input
     * @throws InvalidInputException Invalid Input Exception
     *
     */
    public static void validateInputArray(String[] inputArray) throws InvalidInputException {

        if (inputArray == null || inputArray.length == 0) {
            throw new InvalidInputException(INVALID_ARRAY_MESSAGE);
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (!StringUtils.isNumeric(inputArray[i])) {
                throw new InvalidInputException(NON_NUMERIC_ARRAY_MESSAGE);
            }
        }

    }

    /**
     * Validates top value from input
     * Throws an exception when top is non-numeric
     *
     * @param top - top parameter from the input
     * @throws InvalidInputException Invalid Input Exception
     *
     */
    public static void validateTop(String top) throws InvalidInputException {

        try {
            if (top == null || top.isBlank() || top.isEmpty() || (Integer.parseInt(top) <= 0)) {
                throw new InvalidInputException(INVALID_TOP_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            throw new InvalidInputException(INVALID_TOP_MESSAGE);
        }

    }

    /**
     * Validates input strings
     * Throws an exception when one or more strings are missing
     *
     * @param string1 - String 1 from the input
     * @param string2 - String 2 from the input
     * @throws InvalidInputException Invalid Input Exception
     *
     */
    public static void validateInputStrings(String string1, String string2) throws InvalidInputException {

        if (string1 == null || string1.isBlank() || string1.isEmpty() ||
                string2 == null || string2.isBlank() || string2.isEmpty()) {
            throw new InvalidInputException(INVALID_STRING_MESSAGE);
        }

    }
}
