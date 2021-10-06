package baseball.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

/**
 * Created by Minky on 2021-10-05
 */
public class StrikeModelTest {
    private StrikeModel strikeModel;

    @BeforeEach
    void setUp() {
        strikeModel = new StrikeModel();
        setMockStrikeList();
    }

    @DisplayName(value = "3자리 숫자 랜덤값 생성 테스트")
    @Test
    void initStrikeList() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 2, 3);
            List<Integer> expectStrikeList = Arrays.asList(1, 2, 3);
            strikeModel.initStrikeList();
            assertEquals(strikeModel.getStrikeList(), expectStrikeList);
        }
    }

    @ParameterizedTest(name = "3자리 숫자 등록 및 반환 검증 테스트 [{index}] => `{argumentsWithNames}`")
    @CsvSource(value = {"1, 2, 3", "4, 5, 6", "7, 8, 9"})
    void getStrikeList(int targetOne, int targetTwo, int targetThree) {
        List<Integer> mockStrikeList = getMockStrikeList(targetOne, targetTwo, targetThree);
        strikeModel.setStrikeList(mockStrikeList);
        assertEquals(mockStrikeList, strikeModel.getStrikeList());
    }

    @DisplayName(value = "스트라이크 갯수 0 반환 테스트")
    @Test
    void getStrikeCountReturnZero() {
        int[] mockUserInputArray = {4, 5, 6};
        assertEquals(0, strikeModel.getStrikeCount(mockUserInputArray));
    }

    @DisplayName(value = "스트라이크 갯수 1 반환 테스트")
    @Test
    void getStrikeCountReturnOne() {
        int[] mockUserInputArray = {3, 2, 4};
        assertEquals(1, strikeModel.getStrikeCount(mockUserInputArray));
    }

    @DisplayName(value = "스트라이크 갯수 2 반환 테스트")
    @Test
    void getStrikeCountReturnTwo() {
        int[] mockUserInputArray = {1, 2, 4};
        assertEquals(2, strikeModel.getStrikeCount(mockUserInputArray));
    }

    @DisplayName(value = "스트라이크 갯수 3 반환 테스트")
    @Test
    void getStrikeCountReturnThree() {
        int[] mockUserInputArray = {1, 2, 3};
        assertEquals(3, strikeModel.getStrikeCount(mockUserInputArray));
    }

    @DisplayName(value = "볼 갯수 0 반환 테스트")
    @Test
    void getBallCountReturnZero() {
        int[] mockUserInputArray = {4, 5, 6};
        assertEquals(0, strikeModel.getBallCount(mockUserInputArray));
    }

    @DisplayName(value = "볼 갯수 1 반환 테스트")
    @Test
    void getBallCountReturnOne() {
        int[] mockUserInputArray = {4, 5, 2};
        assertEquals(1, strikeModel.getBallCount(mockUserInputArray));
    }

    @DisplayName(value = "볼 갯수 2 반환 테스트")
    @Test
    void getBallCountReturnTwo() {
        int[] mockUserInputArray = {3, 2, 1};
        assertEquals(2, strikeModel.getBallCount(mockUserInputArray));
    }

    @DisplayName(value = "볼 갯수 3 반환 테스트")
    @Test
    void getBallCountReturnThree() {
        int[] mockUserInputArray = {3, 1, 2};
        assertEquals(3, strikeModel.getBallCount(mockUserInputArray));
    }

    private void setMockStrikeList() {
        List<Integer> mockStrikeList = Arrays.asList(1, 2, 3);
        strikeModel.setStrikeList(mockStrikeList);
    }

    private List<Integer> getMockStrikeList(int targetOne, int targetTwo, int targetThree) {
        List<Integer> mockStrikeList = new ArrayList<Integer>();
        mockStrikeList.add(targetOne);
        mockStrikeList.add(targetTwo);
        mockStrikeList.add(targetThree);
        return mockStrikeList;
    }
}