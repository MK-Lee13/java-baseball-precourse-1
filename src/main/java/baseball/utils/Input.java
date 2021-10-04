package baseball.utils;

import nextstep.utils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Minky on 2021-10-04
 */
public class Input {
    private Pattern pattern;

    public Input() {
        this.pattern = Pattern.compile("[1-9]");
    }

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

    public Boolean isDecimalBetweenOneAndTwo(int targetDecimal) {
        if (targetDecimal > 2 || targetDecimal < 1) {
            return false;
        }
        return true;
    }

    public Boolean isDecimalArrayElementsNotEqual(int[] targetDecimalArray) {
        HashSet<Integer> targetDecimalSet = returnIntArrayToHashSet(targetDecimalArray);
        if (targetDecimalSet.size() != 3) {
            return false;
        }
        return true;
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

    private HashSet<Integer> returnIntArrayToHashSet(int[] targetDecimalArray) {
        HashSet<Integer> targetDecimalSet = new HashSet();
        for (int targetDecimal : targetDecimalArray) {
            targetDecimalSet.add(targetDecimal);
        }
        return targetDecimalSet;
    }

    private int returnDecimalValueCount(String[] targetStringArray) {
        int validDecimalValueCount = 0;
        for (String targetString : targetStringArray) {
            validDecimalValueCount += isDecimalValueReturnPlus(targetString);
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
