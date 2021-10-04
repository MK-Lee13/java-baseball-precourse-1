package baseball.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Minky on 2021-10-04
 */
class InputTest {
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    void typeCastingStringToInt() {
        assertEquals(input.typeCastingStringToInt("0"), 0);
    }

    @Test
    void typeCastingStringArrayToIntArray() {
        String[] inputOneLineStringSplitList = {"1", "2", "3"};
        int[] expectValue = {1, 2, 3};
        assertArrayEquals(input.typeCastingStringArrayToIntArray(inputOneLineStringSplitList), expectValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"011", "102", "201", "912", "123"})
    void isDecimalArrayValidLengthReturnTrue(String inputOneLineString) {
        String[] targetStringArray = inputOneLineString.split("");
        int[] targetDecimalArray = input.typeCastingStringArrayToIntArray(targetStringArray);
        assertTrue(input.isDecimalArrayValidLength(targetDecimalArray));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0111", "1022", "201123", "912444", "12", "1"})
    void isDecimalArrayValidLengthReturnFalseFromNotValidLength(String inputOneLineString) {
        String[] targetStringArray = inputOneLineString.split("");
        int[] targetDecimalArray = input.typeCastingStringArrayToIntArray(targetStringArray);
        assertFalse(input.isDecimalArrayValidLength(targetDecimalArray));
    }

    @ParameterizedTest
    @ValueSource(strings = {"011", "102", "201", "912", "123"})
    void isDecimalStringArrayReturnTrue(String targetString) {
        String[] targetStringArray = targetString.split("");
        assertTrue(input.isDecimalStringArray(targetStringArray));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-11", "asd", "-100", "-1-1", "09-", "", " "})
    void isDecimalStringArrayReturnFalseFromWrongFormat(String targetString) {
        String[] targetStringArray = targetString.split("");
        assertFalse(input.isDecimalStringArray(targetStringArray));
    }

    @ParameterizedTest
    @NullSource
    void isDecimalStringArrayReturnFalseFromNull(String[] targetStringArray) {
        assertFalse(input.isDecimalStringArray(targetStringArray));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void isDecimalReturnTrue(String targetString) {
        assertTrue(input.isDecimal(targetString));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "as", "", " ", "111"})
    void isDecimalReturnFalseFromWrongFormat(String targetString) {
        assertFalse(input.isDecimal(targetString));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isDecimalReturnFalseFromNullAndEmptySource(String targetString) {
        assertFalse(input.isDecimal(targetString));
    }
}