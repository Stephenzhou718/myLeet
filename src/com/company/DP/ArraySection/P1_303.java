package com.company.DP.ArraySection;

import java.util.Collections;

/**
 * 数组区间和
 * 要求：求区间 i～j 的和
 * 难度：Easy
 * 第一次是否做出：否
 */
public class P1_303 {
    class NumArray {
        private int[] dp;
        private int length;
        public NumArray(int[] nums) {
            if(nums != null && nums.length != 0){
                length = nums.length;
                dp = new int[nums.length + 1];

                dp[0] = nums[0];
                for(int i = 1; i <= nums.length; i++){
                    dp[i] = dp[i - 1] + nums[i-1];
                }
            }


        }

        public int sumRange(int i, int j) {
            if (dp == null || i < 0 || j >=length){
                return 0;
            }

            return dp[j + 1] - dp[i];
        }
    }
}
