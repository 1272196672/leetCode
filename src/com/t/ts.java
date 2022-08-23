package com.t;

import java.util.*;

public class ts {
    public static void main(String[] args) {

    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return 0;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        queue.add(beginWord);
        while (!queue.isEmpty()){
            String nowWord = queue.poll();
            int len = map.get(nowWord);
            for (int i = 0; i < nowWord.length(); i++) {
                char[] chars = nowWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String newWord = String.valueOf(chars);
                    if (newWord.equals(endWord)){
                        return len + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)){
                        map.put(newWord, len + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
