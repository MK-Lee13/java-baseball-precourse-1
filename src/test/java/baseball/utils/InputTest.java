package baseball.utils;

import baseball.error.ErrorStatusCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName(value = "숫자야구게임 입력 값 반환 테스트")
    @Test
    void getGameStartUserInput() {
        setMockUserInputString("123");
        int[] expectValue = {1, 2, 3};
        assertArrayEquals(expectValue, input.getGameStartUserInput());
    }

    @DisplayName(value = "숫자야구게임 재시작 입력 값 반환 테스트")
    @Test
    void getGameFinishUserInput() {
        setMockUserInputString("0");
        assertEquals(0, input.getGameFinishUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 재시작 정상 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"1", "2"})
    void validateGameFinishUserInputStatusCorrect(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.CORRECT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 재시작 1, 2 이외의 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9"})
    void validateGameFinishUserInputStatusNotBetweenOneAndTwo(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_BETWEEN_ONE_AND_TWO, input.validateGameFinishUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 재시작 비정상 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"-1", "asd", " ", "", "0"})
    void validateGameFinishUserInputStatusNotDecimalInput(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 재시작 Null 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @NullAndEmptySource
    void validateGameFinishUserInputStatusNotDecimalInputAboutNull(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 정상 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"123", "132", "241", "912", "123"})
    void validateGameStartUserInputStatusCorrect(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.CORRECT, input.validateGameStartUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 중복 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"111", "121", "131", "919", "232"})
    void validateGameStartUserInputStatusElementsEqual(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_ARRAY_ELEMENTS_NOT_EQUAL, input.validateGameStartUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 길이 3초과 3미만의 양수 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"1111", "1122", "241123", "912444", "12", "1"})
    void validateGameStartUserInputStatusNotValidArraySize(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_VALID_ARRAY_SIZE, input.validateGameStartUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 비정상 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @ValueSource(strings = {"0", "-1", "a", "as", "", " "})
    void validateGameStartUserInputStatusNotDecimalInput(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameStartUserInput());
    }

    @ParameterizedTest(name = "숫자야구게임 Null 값 입력 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @NullAndEmptySource
    void validateGameStartUserInputStatusNotDecimalInputAboutNull(String userInputString) {
        input.setUserInputString(userInputString);
        assertEquals(ErrorStatusCode.IS_NOT_DECIMAL_INPUT, input.validateGameFinishUserInput());
    }

    private void setMockUserInputString(String userInputString) {
        input.setUserInputString(userInputString);
    }
}