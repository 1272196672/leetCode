package com.t;

import javax.lang.model.type.UnionType;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class ts {
    public static void main(String[] args) {
        new Solution().rotate(new int[]{1,2,3,4,5,6}, 3);
    }
}


class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    void reverse(int[] nums, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
