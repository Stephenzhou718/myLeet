package com.company.DP.MaxLengthOfIncreaseSequence;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 要求：　时间复杂度应该在　Ｏ（ｎ２）　内，更高的要求是在　o(nlogn) 的时间复杂度内
 * 难度：Medium
 * 第一次是否做出： 是
 */
public class P1_300 {
    public static void main (String[] args) {

    }


    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < nums.length; i++) {
                for(int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }


            int ret = 0;
            for(int i = 0; i < nums.length; i++) {
                ret = Math.max(ret, dp[i]);
            }

            return ret;
        }
    }
}
