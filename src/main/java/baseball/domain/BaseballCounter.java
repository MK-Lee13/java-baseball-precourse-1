package baseball.domain;

import static baseball.message.HintMessage.*;

/**
 * Created by Minky on 2021-10-05
 */
public class BaseballCounter {
    private int strikeCount;
    private int ballCount;
    private String baseballMessage;
    private BaseballStatusCode baseballStatusCode;

    public BaseballCounter(int strikeCount, int ballCount, BaseballStatusCode baseballStatusCode) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.baseballStatusCode = baseballStatusCode;
        this.baseballMessage = makeBaseballMessage();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public String getBaseballMessage() {
        return baseballMessage;
    }

    public BaseballStatusCode getBaseballStatusCode() {
        return baseballStatusCode;
    }

    private String makeBaseballMessage() {
        if (baseballStatusCode == BaseballStatusCode.STRIKE_AND_BALL) {
            return String.format(STRIKE_AND_BALL_MESSAGE, strikeCount, ballCount);
        }
        if (baseballStatusCode == BaseballStatusCode.STRIKE) {
            return String.format(STRIKE_MESSAGE, strikeCount);
        }
        if (baseballStatusCode == BaseballStatusCode.BALL) {
            return String.format(BALL_MESSAGE, ballCount);
        }
        return NOTHING_MESSAGE;
    }
}
