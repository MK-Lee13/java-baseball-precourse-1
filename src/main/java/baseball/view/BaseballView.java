package baseball.view;

import baseball.domain.BaseballCounter;
import baseball.error.ErrorStatusCode;
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

    public void displayHintMessage(BaseballCounter baseballCounter) {
        System.out.println(baseballCounter.getBaseballMessage());
    }

    public void displayErrorMessage(ErrorStatusCode errorStatusCode) {
        System.out.println(errorStatusCode.getValue());
    }
}
