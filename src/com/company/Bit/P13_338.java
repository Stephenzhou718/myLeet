package com.company.Bit;

/**
 * 统计从 0 - n 每个数的位二进制表示中 1 的个数
 * 要求:
 * 难度： Medium
 * 第一次是否做出：
 */
public class P13_338 {
    class Solution {
        public int[] countBits(int num) {
            int[] ret = new int[num + 1];
            for(int i = 1; i <= num; i++){
                ret[i] = ret[i & (i - 1)] + 1;
            }

            return ret;
        }
    }
}
