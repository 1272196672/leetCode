package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] rightEdge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            rightEdge[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int edge = 0;
        int preEdge = -1;
        for (int i = 0; i < s.length(); i++) {
            edge = Math.max(rightEdge[s.charAt(i) - 'a'], edge);
            if (i == edge){
                result.add(edge - preEdge);
                preEdge = edge;
            }
        }
        return result;
    }
}