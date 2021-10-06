package baseball.error;

/**
 * Created by Minky on 2021-10-05
 */
public enum ErrorStatusCode {
    IS_NOT_BETWEEN_ONE_AND_TWO("[ERROR] 1, 2 사이의 숫자 만 입력하세요."),
    IS_NOT_DECIMAL_INPUT("[ERROR] 양수인 숫자 만 입력하세요."),
    IS_NOT_DECIMAL_ARRAY_ELEMENTS_NOT_EQUAL("[ERROR] 중복 되지 않는 3자리의 숫자를 입력하세요."),
    IS_NOT_VALID_ARRAY_SIZE("[ERROR] 3자리의 숫자를 입력하세요."),
    CORRECT("");

    private final String value;

    ErrorStatusCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
