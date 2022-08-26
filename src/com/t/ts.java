package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    Random random = new Random(System.currentTimeMillis());
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    int partition(int[] nums, int left, int right){
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, pivotIndex, left);
        int pivot = nums[left];

//        j代表左区间最后一个元素的位置
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot){
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
