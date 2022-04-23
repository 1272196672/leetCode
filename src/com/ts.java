package com;

import java.util.*;

public class ts {
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b;
        b = a;
        b[1] = 5;
        System.out.println(a[1]);
    }
}