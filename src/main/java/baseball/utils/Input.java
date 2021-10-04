package baseball.utils;

import baseball.error.ErrorStatusCode;
import nextstep.utils.Console;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by Minky on 2021-10-04
 */
public class Input {
    private Pattern pattern;
    private String userInputString;

    public Input() {
        this.pattern = Pattern.compile("[1-9]");
    }

    public void setUserInputString(String userInputString) {
        this.userInputString = userInputString;
    }

    public void setUserInputStringByRead() {
        this.userInputString = Console.readLine();
    }

    public int getGameFinishUserInput() {
        return typeCastingStringToInt(userInputString);
    }

    public int[] getGameStartUserInput() {
        return typeCastingStringArrayToIntArray(userInputString.split(""));
    }

    public ErrorStatusCode validateGameFinishUserInput() {
        if (!isDecimal(userInputString)) {
            return ErrorStatusCode.IS_NOT_DECIMAL_INPUT;
        }
        int userInputDecimal = typeCastingStringToInt(userInputString);
        return returnDecimalUserInputStatusCode(userInputDecimal);
    }

    public ErrorStatusCode validateGameStartUserInput() {
        String[] userInputStringArray = userInputString.split("");
        if (!isDecimalStringArray(userInputStringArray)) {
            return ErrorStatusCode.IS_NOT_DECIMAL_INPUT;
        }
        int[] userInputDecimalArray = typeCastingStringArrayToIntArray(userInputStringArray);
        return returnDecimalArrayUserInputStatusCode(userInputDecimalArray);
    }

    private int typeCastingStringToInt(String inputOneLineString) {
        return Integer.parseInt(inputOneLineString);
    }

    private int[] typeCastingStringArrayToIntArray(String[] inputOneLineStringSplitList) {
        int stringArrayLength = inputOneLineStringSplitList.length;
        int[] result = new int[stringArrayLength];
        for (int i = 0; i < stringArrayLength; i++) {
            result[i] = Integer.parseInt(inputOneLineStringSplitList[i]);
        }
        return result;
    }

    private ErrorStatusCode returnDecimalArrayUserInputStatusCode(int[] targetDecimalArray) {
        if (!isDecimalArrayValidLength(targetDecimalArray)) {
            return ErrorStatusCode.IS_NOT_VALID_ARRAY_SIZE;
        } else if (!isDecimalArrayElementsNotEqual(targetDecimalArray)) {
            return ErrorStatusCode.IS_NOT_DECIMAL_ARRAY_ELEMENTS_NOT_EQUAL;
        }
        return ErrorStatusCode.CORRECT;
    }

    private ErrorStatusCode returnDecimalUserInputStatusCode(int targetDecimal) {
        if (!isDecimalBetweenOneAndTwo(targetDecimal)) {
            return ErrorStatusCode.IS_NOT_BETWEEN_ONE_AND_TWO;
        }
        return ErrorStatusCode.CORRECT;
    }

    private Boolean isDecimalBetweenOneAndTwo(int targetDecimal) {
        if (targetDecimal > 2 || targetDecimal < 1) {
            return false;
        }
        return true;
    }

    private Boolean isDecimalArrayElementsNotEqual(int[] targetDecimalArray) {
        HashSet<Integer> targetDecimalSet = returnIntArrayToHashSet(targetDecimalArray);
        if (targetDecimalSet.size() != 3) {
            return false;
        }
        return true;
    }

    private Boolean isDecimalArrayValidLength(int[] targetDecimalArray) {
        if (targetDecimalArray.length == 3) {
            return true;
        }
        return false;
    }

    private Boolean isDecimalStringArray(String[] targetStringArray) {
        if (targetStringArray == null) {
            return false;
        }
        int validDecimalValueCount = returnDecimalValueCount(targetStringArray);
        if (validDecimalValueCount == targetStringArray.length) {
            return true;
        }
        return false;
    }

    private Boolean isDecimal(String targetString) {
        if (targetString == null) {
            return false;
        }
        return pattern.matcher(targetString).matches();
    }

    private HashSet<Integer> returnIntArrayToHashSet(int[] targetDecimalArray) {
        HashSet<Integer> targetDecimalSet = new HashSet<Integer>();
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
