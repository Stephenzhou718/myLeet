package com.company.Bit;

/**
 * 判断一个数的位级表示是否不会出现连续的 0 和 1
 * 要求：
 * 难度： Easy
 * 第一次是否做出：否
 * 反思： 可以从正例和反例两个方面分析，不满足正例的就是反例，可以用假设法
 *
 */
public class P9_693 {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int a = (n ^ (n >> 1));
            return (a & (a + 1)) == 0;
        }
    }
}
