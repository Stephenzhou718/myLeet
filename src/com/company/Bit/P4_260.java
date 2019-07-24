package com.company.Bit;

/**
 * 数组中不重复的两个元素
 * 要求: 线性时间复杂度，常数空间复杂度
 * 难度：Medium
 * 第一次是否做出： 否， 卡在怎么鉴别出最后的两个数
 */
public class P4_260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int diff = 0;
            for(int num : nums) diff ^= num;
            diff &= -diff;  //取出最低位的 1

            int[] ret = new int[2];
            for(int num : nums){
                if((num & diff) == 0) ret[0] ^= num;
                else ret[1] ^= num;
            }

            return ret;
        }
    }
}
