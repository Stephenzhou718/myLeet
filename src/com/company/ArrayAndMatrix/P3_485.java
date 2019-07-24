package com.company.ArrayAndMatrix;

/**
 * 找出数组中最长的连续 1
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P3_485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxCount = 0;
            int beginCount = 0;
            if(nums == null || nums.length == 0){
                return 0;
            }

            for(int i : nums){
                if(i == 1){
                    beginCount++;
                }else {
                    maxCount = maxCount > beginCount? maxCount : beginCount;
                    beginCount = 0;
                }
            }
            return maxCount > beginCount? maxCount:beginCount;
        }
    }
}
