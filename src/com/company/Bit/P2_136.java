package com.company.Bit;

/**
 * 数组中唯一一个不重复的元素
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 * 反思： 做位运算的题目一定要记住位运算的一些性质
 */
public class P2_136 {
    class Solution {
        public int singleNumber(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int ret = 0;
            for(int num : nums){
                ret ^= num;
            }

            return ret;
        }
    }
}
