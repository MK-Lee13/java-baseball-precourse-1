package baseball.utils;

import baseball.error.ErrorStatusCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Minky on 2021-10-04
 */
public class InputTest {
    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    void getGameFinishUserInput() {
        setMockUserInputString("0");
        assertEquals(0, input.getGameFinishUserInput());
    }

    @Test
    void getGameStartUserInput() {
        setMockUserInputString("123");
        int[] expectValue = {1, 2, 3};
        assertArrayEquals(expectValue, input.getGameStartUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void validateGameFinishUserInputStatusCorrect(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.CORRECT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9"})
    void validateGameFinishUserInputStatusNotBetweenOneAndTwo(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_BETWEEN_ONE_AND_TWO, input.validateGameFinishUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "asd", " ", "", "0"})
    void validateGameFinishUserInputStatusNotDecimalInput(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateGameFinishUserInputStatusNotDecimalInputAboutNull(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "132", "241", "912", "123"})
    void validateGameStartUserInputStatusCorrect(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.CORRECT, input.validateGameStartUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "121", "131", "919", "232"})
    void validateGameStartUserInputStatusElementsEqual(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_ARRAY_ELEMENTS_NOT_EQUAL, input.validateGameStartUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111", "1122", "241123", "912444", "12", "1"})
    void validateGameStartUserInputStatusNotValidArraySize(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_VALID_ARRAY_SIZE, input.validateGameStartUserInput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "a", "as", "", " "})
    void validateGameStartUserInputStatusNotDecimalInput(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameStartUserInput());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateGameStartUserInputStatusNotDecimalInputAboutNull(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    private void setMockUserInputString(String userInputString) {
        input.setUserInputString(userInputString);
    }
}