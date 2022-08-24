package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    int n;
    int[] father;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        n = edges.length;
        int[] inDegree = new int[n + 1];
        father = new int[n + 1];

        for (int i = 0; i < n; i++) {
            inDegree[edges[i][1]] += 1;
        }

        ArrayList<Integer> errorEdge = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2){
                errorEdge.add(i);
            }
        }

        if (!errorEdge.isEmpty()){
            if (isTreeAfterRemoveEdge(edges, errorEdge.get(0))){
                return edges[errorEdge.get(0)];
            }
            return edges[errorEdge.get(1)];
        }
        return getEdgeCanBeRemoved(edges);
    }

    int[] getEdgeCanBeRemoved(int[][] edges){
        init();
        for (int i = 0; i < n; i++) {
            if (isSameFather(edges[i][0], edges[i][1])){
                return edges[i];
            }
            join(edges[i][0], edges[i][1]);
        }
        return new int[]{};
    }

    boolean isTreeAfterRemoveEdge(int[][] edges, int errorEdge){
        init();
        for (int i = 0; i < n; i++) {
            if (i == errorEdge){
                continue;
            }
            if (isSameFather(edges[i][0], edges[i][1])){
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    void init(){
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
        father[v] = u;
    }

    boolean isSameFather(int u, int v){
        return find(u) == find(v);
    }
}
