package com;

import java.util.*;

public class ts {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("BDHS");
        arrayList.add("KFHS");
        arrayList.add("ABFL");
        arrayList.add("ZLDI");
        arrayList.sort(Comparator.comparing(String::toString));
        System.out.println(arrayList);
    }
}