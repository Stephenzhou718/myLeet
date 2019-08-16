package com.company.DP.MaxLengthOfIncreaseSequence;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最长摆动子序列
 * 要求： 使用 O（n) 时间复杂度求解
 * 难度： Medium
 * 第一次是否做出： 是，虽然调试了很多次（两种测试用例没有考虑到），虽然时间效率只有 24.78%
 */
public class P3_376 {
    public static void main (String[] args) {

    }

    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length <= 2) {
                return 1;
            }

            // 构建差值数组
            int[] newNums = new int[nums.length - 1];
            for(int i = 0; i < nums.length - 1; i++) {
                newNums[i] = nums[i + 1] - nums[i];
            }

            int[] dp = new int[nums.length - 1];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length - 1; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (newNums[i] * newNums[j] < 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }


            int index = 0;
            int max = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if(dp[i] > max) {
                    max = dp[i];
                    index = i;
                }
            }

            return nums[index + 1] == nums[index] ? max: max + 1;
        }
    }


    /**
     * 网上代码 只用了 O（n） 的时间复杂度求解
     * 时间效率 100%
     * 空间效率 100%
     */
    class Solution2 {
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int up = 1, down = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                } else if (nums[i] < nums[i - 1]) {
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }
}
