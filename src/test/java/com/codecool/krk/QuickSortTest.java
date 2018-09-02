package com.codecool.krk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void Should_ReturnEmptyList_When_CalledSortWithEmptyList() {
        List<Integer> toSort = new ArrayList<>();
        QuickSort.sort(toSort);
        assertTrue(toSort.isEmpty());
    }

    @Test
    void Should_ReturnSortedList_When_CalledSortMethod() {
        List<Integer> testList = getTestList();
        List<Integer> toSort = new ArrayList<>(testList);
        QuickSort.sort(toSort);

        assertAll(
                () -> assertEquals(toSort.size(), testList.size()),
                () -> assertEquals(new Integer(-3), toSort.get(0)),
                () -> assertEquals(new Integer(1), toSort.get(1)),
                () -> assertEquals(new Integer(3), toSort.get(2)),
                () -> assertEquals(new Integer(31), toSort.get(3))
        );
    }

    @Test
    void Should_ReturnSortedList_When_CalledSortMethodWithRandomValues() {
        List<Integer> testList = getRandomTestList(32);
        List<Integer> toSort = new ArrayList<>(testList);
        QuickSort.sort(toSort);
        Collections.sort(testList);
        assertEquals(testList, toSort);
    }

    private List<Integer> getTestList() {
        List<Integer> toSort = new ArrayList<>();
        toSort.add(-3);
        toSort.add(3);
        toSort.add(31);
        toSort.add(1);
        return toSort;
    }

    private List<Integer> getRandomTestList(int size) {
        List<Integer> toSort = new ArrayList<>(size);
        Random rng = new Random();
        for(int i = 0; i < size; i++) {
            toSort.add(rng.nextInt( 101));
        }
        return toSort;
    }

}