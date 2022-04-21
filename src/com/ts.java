package com;

import java.util.*;

public class ts {
    public static void main(String[] args) {
        int[][] people = new int[4][2];
        people[0] = new int[]{1, 1};
        people[1] = new int[]{7, 4};
        people[2] = new int[]{3, 2};
        people[3] = new int[]{1, 2};
        Arrays.sort(people, Comparator.comparing(o -> -o[0]));
        for (int[] ints : people) {
            System.out.println(Arrays.toString(ints));
        }

    }
}