package baseball.message;

/**
 * Created by Minky on 2021-10-06
 */
public final class InputMessage {
    private InputMessage() { }

    public static String NUMERIC_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String CORRECT_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
}
