package com.codecool.krk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void Should_ReturnIndexOfElement_When_ElementExistsInList () {
        List<Integer> list = new ArrayList<>(32);
        for(int i = 0; i < list.size(); i++) {
            list.add(i * 2 + 5);
        }

        for(int i = 0; i < list.size(); i++) {
            Integer searchedIndex = i;
            int searchedValue = i * 2 + 5;
            Integer foundIndex = BinarySearch.find(searchedValue, list);
            assertEquals(searchedIndex, foundIndex);
        }
    }

    @Test
    void Should_ReturnNegativeOne_When_SearchedElementIsNotInList() {
        final List<Integer> list = new ArrayList<Integer>(8);
        for(int i = 0; i < list.size(); i++) {
            list.add(i * 2 + 5);
        }

        final Integer expected = -1;
        assertAll(
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-20), list)),
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-2), list)),
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-210), list)),
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-203), list)),
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-220), list)),
                () -> assertEquals(expected, (Integer) BinarySearch.find(new Integer(-30), list))
        );
    }
}