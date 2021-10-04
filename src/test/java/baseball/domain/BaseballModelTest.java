package baseball.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
public class BaseballModelTest {
    private BaseballModel baseballModel;

    @BeforeEach
    void setUp() {
        baseballModel = new BaseballModel();
        setMockStrikeList();
    }

    @Test
    void initStrikeList() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 2, 3);
            List<Integer> expectStrikeList = Arrays.asList(1, 2, 3);
            baseballModel.initStrikeList();
            assertEquals(baseballModel.getStrikeList(), expectStrikeList);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3", "4, 5, 6", "7, 8, 9"})
    void getStrikeList(int targetOne, int targetTwo, int targetThree) {
        List<Integer> mockStrikeList = getMockStrikeList(targetOne, targetTwo, targetThree);
        baseballModel.setStrikeList(mockStrikeList);
        assertEquals(mockStrikeList, baseballModel.getStrikeList());
    }

    @Test
    void getStrikeCountReturnOne() {
        int[] mockUserInputArray = {3, 2, 4};
        assertEquals(1, baseballModel.getStrikeCount(mockUserInputArray));
    }

    @Test
    void getStrikeCountReturnTwo() {
        int[] mockUserInputArray = {1, 2, 4};
        assertEquals(2, baseballModel.getStrikeCount(mockUserInputArray));
    }

    @Test
    void getStrikeCountReturnThree() {
        int[] mockUserInputArray = {1, 2, 3};
        assertEquals(3, baseballModel.getStrikeCount(mockUserInputArray));
    }

    @Test
    void getBallCountReturnOne() {
        int[] mockUserInputArray = {4, 5, 2};
        assertEquals(1, baseballModel.getBallCount(mockUserInputArray));
    }

    @Test
    void getBallCountReturnTwo() {
        int[] mockUserInputArray = {3, 2, 1};
        assertEquals(2, baseballModel.getBallCount(mockUserInputArray));
    }

    @Test
    void getBallCountReturnThree() {
        int[] mockUserInputArray = {3, 1, 2};
        assertEquals(3, baseballModel.getBallCount(mockUserInputArray));
    }

    private void setMockStrikeList() {
        List<Integer> mockStrikeList = Arrays.asList(1, 2, 3);
        baseballModel.setStrikeList(mockStrikeList);
    }

    private List<Integer> getMockStrikeList(int targetOne, int targetTwo, int targetThree) {
        List<Integer> mockStrikeList = new ArrayList<Integer>();
        mockStrikeList.add(targetOne);
        mockStrikeList.add(targetTwo);
        mockStrikeList.add(targetThree);
        return mockStrikeList;
    }
}