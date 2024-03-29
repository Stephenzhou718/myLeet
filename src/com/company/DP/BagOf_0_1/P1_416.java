package com.company.DP.BagOf_0_1;

/**
 * 划分数组为和相等的两部分
 * 要求：
 * 难度： Medium
 * 第一次是否做出： 否,头大，看答案都看不懂
 */
public class P1_416 {
    public static void main (String[] args) {

    }

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = computeArraySum(nums);
            if (sum % 2 != 0) {
                return false;
            }
            int W = sum / 2;
            boolean[] dp = new boolean[W + 1];
            dp[0] = true;
            for (int num : nums) {                 // 0-1 背包一个物品只能用一次
                for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[W];
        }

        private int computeArraySum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }
}
