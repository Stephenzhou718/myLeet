package com.company.DP.FibonacciSequence;

/**
 * 抢到在环形街区抢劫
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否
 * 反思： 可以把一个题降解成之间见过的题型
 */
public class P3_213 {
    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int n = nums.length;
            if(n == 1){
                return nums[0];
            }

            return Math.max(rob(nums, 0, n -2), rob(nums, 1, n - 1));
        }

        public int rob(int[] nums, int first, int last){
            int pre2 = 0, pre1 = 0;
            for(int i = first; i <= last; i++){
                int cur = Math.max(pre1, pre2 + nums[i]);
                pre2 = pre1;
                pre1 = cur;
            }

            return pre1;
        }
    }
}
