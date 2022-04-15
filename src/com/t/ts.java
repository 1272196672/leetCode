package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder ip = new StringBuilder();
    int num = 0;
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12){
            return result;
        }
        backTracing(s, 0);
        return result;
    }

    public void backTracing(String s, int startIndex){
        if (num == 4 && startIndex == s.length()){
            result.add(ip + "");
            return;
        }
        if (num == 4){
            return;
        }
        for (int i = startIndex; i < s.length() && i - startIndex < 3 && Integer.parseInt(s.substring(startIndex, i + 1)) >= 0 && Integer.parseInt(s.substring(startIndex, i + 1)) <= 255 && s.length() - startIndex - 1 <= 4 * (4 - num); i++) {
            if (i - startIndex > 0 && s.charAt(startIndex) == '0'){
                continue;
            }
            ip.append(s.substring(startIndex, i + 1));
            if (num < 3){
                ip.append('.');
            }
            num++;
            backTracing(s, i + 1);
            num--;
            if (num < 3){
                ip.deleteCharAt(ip.length() - 1);
            }
            ip.delete(startIndex + num, i + num + 1);
        }
    }
}