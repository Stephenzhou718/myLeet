package com.company.Hash;

import java.util.HashMap;

/**
 * 最长和谐队列
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 */
public class P3_594 {
    class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer, Integer> countForNum = new HashMap<>();
            for(int num : nums){
                countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
            }

            int longest = 0;

            for(int num : countForNum.keySet()){
                if(countForNum.containsKey(num + 1)){
                    longest = Math.max(longest, countForNum.get(num) + countForNum.get(num + 1));
                }
            }
            return longest;
        }
    }
}

