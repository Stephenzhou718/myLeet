package com.company.DP.BagOf_0_1;

/**
 * 改变一组数的正负号使得它们的和为一给定数
 * 要求：
 * 难度：Ｍｅｄｉｕｍ
 * 第一次是否做出：　否
 */
public class P2_494 {
    public static void main (String[] args) {

    }

    class Solution {
        // 暴力搜索法求解
        public int findTargetSumWays(int[] nums, int S) {
            return findTargetSumWays(nums, 0, S);
        }

        private int findTargetSumWays(int[] nums, int start, int S) {
            if(start == nums.length) {
                return S == 0? 1: 0;
            }

            return findTargetSumWays(nums, start + 1, S - nums[start]) + findTargetSumWays(nums, start + 1, S + nums[start]);
        }
    }
}
