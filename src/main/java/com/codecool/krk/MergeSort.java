package com.codecool.krk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MergeSort {

    static List<Integer> sort(List<Integer> toSort) {
        if (toSort.size() <= 1) {
            return toSort;
        }

        int middleIndex = toSort.size() / 2;
        List<Integer> left = sort(createCopyOf(toSort, 0, middleIndex));
        List<Integer> right = sort(createCopyOf(toSort, middleIndex, toSort.size()));

        List<Integer> result = new ArrayList<>();
        while(!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty()) {
                while(!right.isEmpty()) {
                    result.add(right.remove(0));
                }
            } else if (right.isEmpty()) {
                while(!left.isEmpty()) {
                    result.add(left.remove(0));
                }
            } else {
                if (left.get(0) < right.get(0)) {
                    result.add(left.remove(0));
                } else {
                    result.add(right.remove(0));
                }
            }
        }

        return result;
    }

    static List<Integer> createCopyOf(List<Integer> toCopy, int iStart, int iEnd) {
        List<Integer> copy = new LinkedList<>();
        for(int i = iStart; i < iEnd; i++) {
            copy.add(toCopy.get(i));
        }
        return copy;
    }
}
