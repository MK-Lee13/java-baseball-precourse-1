package baseball.domain;

import nextstep.utils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballModel {
    private List<Integer> strikeList;

    public BaseballModel() {
        initStrikeList();
    }

    public void initStrikeList() {
        HashSet<Integer> strikeSet = new HashSet();
        while (strikeSet.size() != 3) {
            strikeSet.add(Randoms.pickNumberInRange(1, 9));
        }
        this.strikeList = new ArrayList(strikeSet);
    }

    public int getStrikeCount(int[] userInputArray) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += compareInt(strikeList.get(i), userInputArray[i]);
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
