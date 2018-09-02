package com.codecool.krk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void Should_ReturnPartOfList_When_CopiedListInRange() {
        List<Integer> toCopy = getTestList();   // -3, 3, 31, -1
        List<Integer> copy = MergeSort.createCopyOf(toCopy, 0, 2);
        assertAll(
                () -> assertEquals(new Integer(2), new Integer(copy.size())),
                () -> assertEquals(new Integer(-3), copy.get(0)),
                () -> assertEquals(new Integer(3), copy.get(1))
        );
    }

    @Test
    void Should_ReturnEmptyList_When_CalledSortWithEmptyList() {
        List<Integer> toSort = new ArrayList<>();
        List<Integer> sorted = MergeSort.sort(toSort);
        assertTrue(sorted.isEmpty());
    }

    @Test
    void Should_ReturnSortedList_When_CalledSortMethod() {
        List<Integer> toSort = getTestList();   // -3, 3, 31, -1
        List<Integer> sorted = MergeSort.sort(toSort);

        assertAll(
                () -> assertEquals(toSort.size(), sorted.size()),
                () -> assertEquals(new Integer(-3), sorted.get(0)),
                () -> assertEquals(new Integer(1), sorted.get(1)),
                () -> assertEquals(new Integer(3), sorted.get(2)),
                () -> assertEquals(new Integer(31), sorted.get(3))
        );
    }

    @Test
    void Should_ReturnSortedList_When_CalledSortMethodWithRandomValues() {
        List<Integer> toSort = getRandomTestList(32);
        List<Integer> sorted = MergeSort.sort(toSort);
        Collections.sort(toSort);
        assertEquals(toSort, sorted);
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