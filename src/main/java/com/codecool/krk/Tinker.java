package com.codecool.krk;

import java.util.ArrayList;
import java.util.List;

public class Tinker {

    public static List<Integer> tailor(List<Integer> kids, int step) {
        int kidsTotal = kids.size();
        List<Integer> result = new ArrayList<>();
        int index = getNextIndex(0, step, kidsTotal);
        while (kids.size() > 0) {
            int kid = kids.remove(index);
            kidsTotal--;
            index = getNextIndex(index, step, kidsTotal);
            result.add(kid);
        }
        return result;
    }

    private static int getNextIndex(int currentIndex, int step, int max) {
        if (max == 0) {
            return 0;
        }
        int nextIndex = (currentIndex - 1 + step) % max;
        if (nextIndex < 0) {
            return  0;
        }
        return nextIndex;
    }
}
