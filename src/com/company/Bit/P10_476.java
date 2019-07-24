package com.company.Bit;

/**
 * 求一个数的补码
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否， 不知道怎么求掩码
 */
public class P10_476 {
    class Solution {
        public int findComplement(int num) {
            if(num == 0) return 1;
            int mask = Integer.highestOneBit(num);
            return num ^ ((mask <<= 1) - 1);
        }
    }
}
