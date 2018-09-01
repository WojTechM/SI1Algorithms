package com.codecool.krk;

import java.util.List;

public class BinarySearch {

    public static int find(int searchedValue, List<Integer> allValues) {
        return find(searchedValue, allValues, 0, allValues.size() - 1);
    }

    public static int find(int searchedValue, List<Integer> allValues, int startI, int endI) {
        int index;
        while (startI < endI) {
            index = (int) Math.floor(allValues.size() / 2);
            int currentValue = allValues.get(index);
            if (currentValue == searchedValue) {
                return index;
            } else if (currentValue < searchedValue) {
                endI = index;
            } else {
                startI = index;
            }
        }
        return -1;
    }
}
