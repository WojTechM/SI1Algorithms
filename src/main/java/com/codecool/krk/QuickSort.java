package com.codecool.krk;

import java.util.List;

class QuickSort {

    static void sort(List<Integer> toSort) {
        int iStart = 0;
        int iEnd = toSort.size() - 1;
        sort(toSort, iStart, iEnd);
    }

    static void sort(List<Integer> toSort, int iStart, int iEnd) {
        if (iStart < iEnd) {
            int divisionIndex = quicksort(toSort, iStart, iEnd);
            sort(toSort, iStart, divisionIndex - 1);
            sort(toSort, divisionIndex + 1, iEnd);
        }
    }

    private static int quicksort(List<Integer> toSort, int iStart, int iEnd) {
        int divisionIndex = getMiddleIndex(iStart, iEnd);
        int valueOfDivisor = toSort.get(divisionIndex);
        swap(toSort, divisionIndex, iEnd);

        int currentIndex = iStart;
        for(int i = iStart; i < iEnd; i++) {
            if (toSort.get(i) < valueOfDivisor) {
                swap(toSort, currentIndex, i);
                currentIndex++;
            }
        }

        swap(toSort, currentIndex, iEnd);
        return currentIndex;
    }

    private static int getMiddleIndex(int i1, int i2) {
        return (i1 + i2) / 2;
    }

    private static void swap(List<Integer> list, int i1, int i2) {
        Integer temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
}
