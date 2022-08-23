package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<Boolean> visited = new ArrayList<>(){{
            for (int i = 0; i < rooms.size(); i++) {
                add(false);
            }
        }};
        backtracking(0, rooms, visited);
        for (Boolean aBoolean : visited) {
            if (!aBoolean){
                return false;
            }
        }
        return true;
    }
    void backtracking(int key, List<List<Integer>> rooms, ArrayList<Boolean> visited){
        if (visited.get(key)){
            return;
        }
        visited.set(key, true);
        for (Integer integer : rooms.get(key)) {
            backtracking(integer, rooms, visited);
        }
    }
}
