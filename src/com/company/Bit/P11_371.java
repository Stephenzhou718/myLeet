package com.company.Bit;

/**
 * 实现整数的加法
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否， 没见过
 */
public class P11_371 {
    class Solution {
        public int getSum(int a, int b) {
            return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        }
    }
}
