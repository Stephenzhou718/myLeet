package com.company.Bit;

/**
 * 统计两个数的二进制表示有多少位不同
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P1_461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int ret = x ^ y;
            return Integer.bitCount(ret);
        }
    }
}
