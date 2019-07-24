package com.company.Bit;

/**
 * 找出数组中缺失的那个数
 * 要求：线性复杂度，只能使用额外的常数空间
 * 难度：Easy
 * 第一次是否做出：是，但是没有用位运算的方法
 */
public class P3_268 {
    public static void main(String[] args){
        System.out.println(new P3_268().new Solution().missingNumber(new int[]{3,0,1}));
    }
    class Solution {
        public int missingNumber(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int sum = ((nums.length + 1) * nums.length) / 2;

            for(int num : nums){
                sum -= num;
            }

            return sum;
        }
    }
}
