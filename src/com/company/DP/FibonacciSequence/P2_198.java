package com.company.DP.FibonacciSequence;

/**
 * 强盗抢劫
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是，但是效率比较低。
 * 反思： 状态转移方程一定要精确
 */
public class P2_198 {
    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int[] dp = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                dp[i] = nums[i];
            }

            for(int i = 2; i < nums.length; i++){
                int max = dp[i];
                for(int j = i - 2; j >= 0; j--){
                    max = Math.max(max, dp[j] + dp[i]);
                }

                dp[i] = max;
            }

            int ret = 0;
            for(int num : dp){
                if(num > ret){
                    ret = num;
                }
            }

            return ret;
        }
    }

    class Solution2 {
        public int rob(int[] nums) {
            int pre2 = 0, pre1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int cur = Math.max(pre1, pre2 + nums[i]);
                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }
    }
}
