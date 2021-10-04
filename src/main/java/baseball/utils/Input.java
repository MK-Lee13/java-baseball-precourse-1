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

    public Boolean isDecimalArrayValidLength(int[] targetDecimalArray) {
        if (targetDecimalArray.length == 3) {
            return true;
        }
        return false;
    }

    public Boolean isDecimalStringArray(String[] targetStringArray) {
        if (targetStringArray == null) {
            return false;
        }
        int validDecimalValueCount = returnDecimalValueCount(targetStringArray);
        if (validDecimalValueCount == targetStringArray.length) {
            return true;
        }
        return false;
    }

    public Boolean isDecimal(String targetString) {
        if (targetString == null) {
            return false;
        }
        return pattern.matcher(targetString).matches();
    }

    private int returnDecimalValueCount(String[] targetStringArray) {
        int validDecimalValueCount = 0;
        for (int i = 0; i < targetStringArray.length; i++) {
            validDecimalValueCount += isDecimalValueReturnPlus(targetStringArray[i]);
        }
        return validDecimalValueCount;
    }

    private int isDecimalValueReturnPlus(String targetString) {
        if (isDecimal(targetString)) {
            return 1;
        }
        return 0;
    }
}
