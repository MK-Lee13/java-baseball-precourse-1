package baseball.view;

/**
 * Created by Minky on 2021-10-04
 */
public class BaseballView {
    public BaseballView() { }

    public void displayNumericInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void displayCorrectStrikesMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void displayRestartOrExitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void displayHintStrikeAndBallMessage(int strikeCount, int ballCount) {
        System.out.println(String.format("%d스트라이크 %d볼", strikeCount, ballCount));
    }

    public void displayHintStrikeMessage(int strikeCount) {
        System.out.println(String.format("%d스트라이크", strikeCount));
    }

    public void displayHintBallMessage(int ballCount) {
        System.out.println(String.format("%d볼", ballCount));
    }

    public void displayHintNothingMessage() {
        System.out.println("낫싱");
    }

    public void displayErrorIsNotBetweenOneAndTwoMessage() {
        System.out.println("[ERROR] 1, 2 사이의 숫자 만 입력하세요.");
    }

    public void displayErrorIsNotDecimalInputMessage() {
        System.out.println("[ERROR] 양수인 숫자 만 입력하세요.");
    }

    public void displayErrorIsNotDecimalArrayElementsNotEqualMessage() {
        System.out.println("[ERROR] 중복 되지 않는 3자리의 숫자를 입력하세요.");
    }

    public void displayErrorIsNotValidArraySizeMessage() {
        System.out.println("[ERROR] 3자리의 숫자를 입력하세요.");
    }
}
