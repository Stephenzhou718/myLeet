package com.company.DP.FibonacciSequence;

/**
 * 爬楼梯
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P1_70 {
    class Solution {
        public int climbStairs(int n) {
            if(n <= 0){
                return 0;
            }else if (n == 1){
                return 1;
            }else if (n == 2){
                return 2;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for(int i = 3; i < n + 1; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
