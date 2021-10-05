package baseball.domain;

/**
 * Created by Minky on 2021-10-05
 */
public class BaseballCounter {
    private int strikeCount;
    private int ballCount;
    private BaseballStatusCode baseballStatusCode;

    public BaseballCounter(int strikeCount, int ballCount, BaseballStatusCode baseballStatusCode) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.baseballStatusCode = baseballStatusCode;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public BaseballStatusCode getBaseballStatusCode() {
        return baseballStatusCode;
    }
}
