package baseball.controller;

import baseball.domain.BaseballCounter;
import baseball.domain.BaseballStatusCode;
import baseball.error.ErrorStatusCode;
import baseball.service.BaseballService;
import baseball.utils.Input;
import baseball.view.BaseballView;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballController {
    private BaseballService baseballService;
    private BaseballView baseballView;
    private Input input;

    public BaseballController() {
        this.baseballService = new BaseballService();
        this.baseballView = new BaseballView();
        this.input = new Input();
    }

    public void executeProgram() {
        do {
            startGame();
            baseballService.setUserInput(validateFinishInputAndReturnInt());
        } while (baseballService.isRestart());
    }

    private void startGame() {
        baseballService.initGame();
        do {
            baseballService.setUserInputArray(validateStartInputAndReturnIntArray());
            responseHintMessage(baseballService.getBaseballCounter());
        } while (baseballService.isKeepGoing());
        baseballView.displayCorrectStrikesMessage();
    }

    private int validateFinishInputAndReturnInt() {
        ErrorStatusCode errorStatusCode;
        do {
            baseballView.displayRestartOrExitMessage();
            input.setUserInputStringByRead();
            errorStatusCode = input.validateGameFinishUserInput();
            responseErrorMessage(errorStatusCode);
        } while (errorStatusCode != ErrorStatusCode.CORRECT);
        return input.getGameFinishUserInput();
    }

    private int[] validateStartInputAndReturnIntArray() {
        ErrorStatusCode errorStatusCode;
        do {
            baseballView.displayNumericInputMessage();
            input.setUserInputStringByRead();
            errorStatusCode = input.validateGameStartUserInput();
            responseErrorMessage(errorStatusCode);
        } while (errorStatusCode != ErrorStatusCode.CORRECT);
        return input.getGameStartUserInput();
    }

    private void responseHintMessage(BaseballCounter baseballCounter) {
        if (baseballCounter.getBaseballStatusCode() == BaseballStatusCode.NOTHING) {
            baseballView.displayHintNothingMessage();
        } else if (baseballCounter.getBaseballStatusCode() == BaseballStatusCode.STRIKE) {
            baseballView.displayHintStrikeMessage(baseballCounter.getStrikeCount());
        } else if (baseballCounter.getBaseballStatusCode() == BaseballStatusCode.BALL) {
            baseballView.displayHintBallMessage(baseballCounter.getBallCount());
        } else if (baseballCounter.getBaseballStatusCode() == BaseballStatusCode.STRIKE_AND_BALL) {
            baseballView.displayHintStrikeAndBallMessage(baseballCounter.getStrikeCount(), baseballCounter.getBallCount());
        }
    }

    private void responseErrorMessage(ErrorStatusCode errorStatusCode) {
        if (errorStatusCode == ErrorStatusCode.IS_NOT_BETWEEN_ONE_AND_TWO) {
            baseballView.displayErrorIsNotBetweenOneAndTwoMessage();
        } else if (errorStatusCode == ErrorStatusCode.IS_NOT_DECIMAL_ARRAY_ELEMENTS_NOT_EQUAL) {
            baseballView.displayErrorIsNotDecimalArrayElementsNotEqualMessage();
        } else if (errorStatusCode == ErrorStatusCode.IS_NOT_DECIMAL_INPUT) {
            baseballView.displayErrorIsNotDecimalInputMessage();
        } else if (errorStatusCode == ErrorStatusCode.IS_NOT_VALID_ARRAY_SIZE) {
            baseballView.displayErrorIsNotValidArraySizeMessage();
        }
    }
}
