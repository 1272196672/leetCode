package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    int[] used;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0){
            return false;
        }
        int target = sum / 4;
        Arrays.sort(matchsticks);
        used = new int[matchsticks.length];
        //反序遍历火柴，大的可以先剪
        return backtracking(matchsticks, new int[4], target, matchsticks.length - 1);
    }

    public boolean backtracking(int[] matchsticks, int[] sides, int target, int startIndex){
        //所有火柴使用完，判断四边是否相等，相等则true
        if (startIndex == -1){
            for (int side : sides) {
                if (side != target){
                    return false;
                }
            }
            return true;
        }

        //外层遍历四边，内层遍历火柴，相当于将每根火柴按顺序和4边比较，有空位则放入
        for (int i = 0; i < sides.length; i++) {
            //火柴长度长于此空位，尝试下一空位
            if (sides[i] + matchsticks[startIndex] > target){
                continue;
            }
            //相同火柴长度的，前面用过，没放进空位，这跟长度相同的也不用比较了
            if (startIndex < matchsticks.length - 1 && matchsticks[startIndex] == matchsticks[startIndex + 1] && used[startIndex + 1] == 0){
                continue;
            }
            //这根火柴过长，所有空位都腾出来也不够放，直接break
            if (i > 0 && startIndex == matchsticks.length - 1){
                break;
            }
            sides[i] += matchsticks[startIndex];
            used[startIndex] = 1;
            if (backtracking(matchsticks, sides, target, startIndex - 1)){
                return true;
            }
            used[startIndex] = 0;
            sides[i] -= matchsticks[startIndex];
        }
        return false;
    }
}   