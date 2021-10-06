package baseball.view;

import baseball.error.ErrorStatusCode;

import static baseball.message.HintMessage.*;
import static baseball.message.InputMessage.*;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballView {
    public BaseballView() { }

    public void displayNumericInputMessage() {
        System.out.print(NUMERIC_INPUT_MESSAGE);
    }

    public void displayCorrectStrikesMessage() {
        System.out.println(CORRECT_STRIKE_MESSAGE);
    }

    public void displayRestartOrExitMessage() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);
    }

    public void displayHintStrikeAndBallMessage(int strikeCount, int ballCount) {
        System.out.println(String.format(STRIKE_AND_BALL_MESSAGE, strikeCount, ballCount));
    }

    public void displayHintStrikeMessage(int strikeCount) {
        System.out.println(String.format(STRIKE_MESSAGE, strikeCount));
    }

    public void displayHintBallMessage(int ballCount) {
        System.out.println(String.format(BALL_MESSAGE, ballCount));
    }

    public void displayHintNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public void displayErrorMessage(ErrorStatusCode errorStatusCode) {
        System.out.println(errorStatusCode.getValue());
    }
}
