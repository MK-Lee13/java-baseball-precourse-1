package baseball.service;

import baseball.domain.BaseballCounter;
import baseball.domain.StrikeModel;
import baseball.domain.BaseballStatusCode;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballService {
    private StrikeModel strikeModel;
    private int[] userInputArray;
    private int userInput;

    public BaseballService() {
        this.strikeModel = new StrikeModel();
    }

    public void initGame() {
        strikeModel.initStrikeList();
    }

    public void setUserInputArray(int[] userInputArray) {
        this.userInputArray = userInputArray;
    }

    public void setUserInput(int userInput) {
        this.userInput = userInput;
    }

    public BaseballCounter getBaseballCounter() {
        int strikeCount = strikeModel.getStrikeCount(userInputArray);
        int ballCount = strikeModel.getBallCount(userInputArray);
        BaseballStatusCode baseballStatusCode = selectBaseballStatusCode(strikeCount, ballCount);
        return new BaseballCounter(strikeCount, ballCount, baseballStatusCode);
    }

    public Boolean isKeepGoing() {
        if (strikeModel.getStrikeCount(userInputArray) == 3) {
            return false;
        }
        return true;
    }

    public Boolean isRestart() {
        if (userInput == 1) {
            return true;
        }
        return false;
    }

    private BaseballStatusCode selectBaseballStatusCode(int strikeCount, int ballCount) {
        if (strikeCount == 3) {
            return BaseballStatusCode.MATCH;
        } else if (strikeCount > 0 && ballCount > 0) {
            return BaseballStatusCode.STRIKE_AND_BALL;
        } else if (strikeCount > 0 && ballCount == 0) {
            return BaseballStatusCode.STRIKE;
        } else if (strikeCount == 0 && ballCount > 0) {
            return BaseballStatusCode.BALL;
        }
        return BaseballStatusCode.NOTHING;
    }
}
