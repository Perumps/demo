package com.example.demo.util;

import com.example.demo.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static com.example.demo.util.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void validCount() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateCount("100");
        });
    }

    @Test
    void nonNumericCount() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateCount("100A");
        });

        assertEquals(ex.getMessage(), INVALID_COUNT_MESSAGE);
    }

    @Test
    void nonIntegerCount() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateCount("100.00");
        });

        assertEquals(ex.getMessage(), INVALID_COUNT_MESSAGE);
    }

    @Test
    void emptyCount() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateCount("");
        });

        assertEquals(ex.getMessage(), INVALID_COUNT_MESSAGE);
    }

    @Test
    void validInputArray() {
        String[] array = {"1","2","3"};
        assertDoesNotThrow(() -> {
            ValidationUtil.validateInputArray(array);
        });
    }
    @Test
    void nonNumericArray() {
        String[] array = {"1","2","3A"};
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateInputArray(array);
        });

        assertEquals(ex.getMessage(), NON_NUMERIC_ARRAY_MESSAGE);
    }

    @Test
    void nonIntegerArray() {
        String[] array = {"1","2","3.00"};
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateInputArray(array);
        });

        assertEquals(ex.getMessage(), NON_NUMERIC_ARRAY_MESSAGE);
    }

    @Test
    void emptyArray() {
        String[] array = {};
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateInputArray(array);
        });

        assertEquals(ex.getMessage(), INVALID_ARRAY_MESSAGE);
    }

    @Test
    void nullArray() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateInputArray(null);
        });

        assertEquals(ex.getMessage(), INVALID_ARRAY_MESSAGE);
    }

    @Test
    void validTop() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateTop("3");
        });
    }

    @Test
    void nonNumericTop() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateTop("3A");
        });

        assertEquals(ex.getMessage(), INVALID_TOP_MESSAGE);
    }

    @Test
    void nonIntegerTop() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateTop("3.00");
        });

        assertEquals(ex.getMessage(), INVALID_TOP_MESSAGE);
    }

    @Test
    void emptyTop() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateTop("");
        });

        assertEquals(ex.getMessage(), INVALID_TOP_MESSAGE);
    }


}