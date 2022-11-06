package com.example.demo.util;

import com.example.demo.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static com.example.demo.util.Constants.INVALID_COUNT_MESSAGE;
import static com.example.demo.util.Constants.MISSING_COUNT_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void validCount() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateCount("100");
        });
    }

   /* @Test
    void validLongUrl() {
        assertDoesNotThrow(() -> {
            ValidationUtil.validateCount(100);
        });
    }

    @Test
    void missingLongUrl() {
        Exception ex = assertThrows(InvalidInputException.class, () -> {
            ValidationUtil.validateCount(100);
        });

        assertEquals(ex.getMessage(), MISSING_URL_MESSAGE);
    }
*/


}