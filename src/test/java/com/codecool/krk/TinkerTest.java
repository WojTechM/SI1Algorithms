package com.codecool.krk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TinkerTest {

    @Test
    void Should_ReturnCopyOfGivenList_When_StepIsZero() {
        List<Integer> kids = createListWithValuesUpTo(5);
        int step = 0;
        int kidsSize = 4;
        List<Integer> result = Tinker.tailor(kids, step);
        assertEquals(kidsSize, result.size());
        for(int i = 0; i < result.size(); i++) {
            assertEquals(new Integer(i + 1), result.get(i));
        }
    }

    @Test
    void Should_ReturnValidData_When_UnderNormalUsage() {
        List<Integer> kids = createListWithValuesUpTo(6);
        int step = 3;
        int kidsSize = 5;

        List<Integer> result = Tinker.tailor(kids, step);
        assertEquals(kidsSize, result.size());

        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(3);
        expectedResult.add(1);
        expectedResult.add(5);
        expectedResult.add(2);
        expectedResult.add(4);

        for(int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    private List<Integer> createListWithValuesUpTo(int limit) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < limit; i++) {
            list.add(i);
        }
        return list;
    }
}