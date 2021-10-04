package baseball.domain;

import java.util.List;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballModel {
    private List<Integer> randomValue;

    public BaseballModel(List<Integer> randomValue) {
        this.randomValue = randomValue;
    }

    public int getStrikeCount(int[] userInputArray) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += compareInt(randomValue.get(i), userInputArray[i]);
        }
        return result;
    }

    private int compareInt(int targetInt, int compareInt) {
        if (targetInt == compareInt) {
            return 1;
        }
        return 0;
    }
}
