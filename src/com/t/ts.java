package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0){
            result++;
        }
        return result;
    }
    public int traversal(TreeNode root){

        if (root == null){
            return 2;
        }

        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == 2 && right == 2){
            return 0;
        }

        if (left == 0 || right == 0){
            result++;
            return 1;
        }

        if (left == 1 || right == 1){
            return 2;
        }
        return 0;
    }
}