package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    int n = 1003;
    int[] father = new int[n + 1];
    public int[] findRedundantConnection(int[][] edges) {
        init(father);
        for (int[] edge : edges) {
            if (isSameFather(edge[0], edge[1])) {
                return edge;
            }
            join(edge[0], edge[1]);
        }
        return new int[]{};
    }

    void init(int[] father){
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    int find(int u){
        return u == father[u] ? u : find(father[u]);
    }

    void join(int u, int v){
        u = find(u);
        v = find(v);
        if (u == v){
            return;
        }
        father[v] = father[u];
    }

    boolean isSameFather(int u, int v){
        u = find(u);
        v = find(v);
        return u == v;
    }
}
