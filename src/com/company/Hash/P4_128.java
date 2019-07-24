package com.company.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 * 要求：
 * 难度：Hard
 * 第一次是否做出：否
 */
public class P4_128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> countFotNum = new HashMap<>();
            for(int num : nums){
                countFotNum.put(num, 1);
            }

            for(int num : nums){
                forward(countFotNum, num);
            }

            return maxCount(countFotNum);
        }

        private int forward(Map<Integer, Integer> countForNum, int num){
            if(!countForNum.containsKey(num)){
                return 0;
            }

            int cnt = countForNum.get(num);
            if(cnt > 1){
                return cnt;
            }

            cnt = forward(countForNum, num + 1) + 1;
            countForNum.put(num, cnt);
            return cnt;

        }

        private int maxCount(Map<Integer, Integer> countForNum){
            int max = 0;
            for(int num : countForNum.keySet()){
                max = Math.max(max, countForNum.get(num));
            }

            return max;
        }
    }
}
