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
        baseballView.displayHintMessage(baseballCounter);
    }

    private void responseErrorMessage(ErrorStatusCode errorStatusCode) {
        if (errorStatusCode != ErrorStatusCode.CORRECT) {
            baseballView.displayErrorMessage(errorStatusCode);
        }
    }
}
