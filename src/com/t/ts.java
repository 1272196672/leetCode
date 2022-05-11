package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
//        找到目标，直接返回目标
        if (root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        左边右边都找到目标了，说明自身是祖先节点，返回
        if (left != null && right != null){
            return root;
        }
//        左边没找到，右边找到了，返回右边继续寻找。或者已经找到了，目的是返回根节点
        else if (left == null && right != null){
            return right;
        }
//        同理
        else if (left != null && right == null){
            return left;
        }
//        没找到，返回空
        return null;
    }
}