package baseball.utils;

import nextstep.utils.Console;

import java.util.regex.Pattern;

/**
 * Created by Minky on 2021-10-04
 */
public class Input {
    private Pattern pattern = Pattern.compile("\\d");

    public String getInputOneLine() {
        String inputOneLineString = Console.readLine();
        return inputOneLineString;
    }

    public int typeCastingStringToInt(String inputOneLineString) {
        return Integer.parseInt(inputOneLineString);
    }

    public int[] typeCastingStringArrayToIntArray(String[] inputOneLineStringSplitList) {
        int stringArrayLength = inputOneLineStringSplitList.length;
        int[] result = new int[stringArrayLength];
        for (int i = 0; i < stringArrayLength; i++) {
            result[i] = Integer.parseInt(inputOneLineStringSplitList[i]);
        }
        return result;
    }
}
