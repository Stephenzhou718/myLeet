package com.company.Bit;

/**
 * 翻转一个数的比特位（把一个数的二进制给颠倒过来）
 * 要求:
 * 难度：Easy
 * 第一次是否做出：否， 没有思路
 * 反思： 位的操作， 记住二进制的一些特殊的操作
 */
public class P5_190 {
    public static void main(String[] args){
        System.out.println(1 << 1);
//        new P5_190().new Solution().reverseBits(43261596);
    }
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ret = 0;
            for(int i = 0; i < 32; i++){
                ret <<= 1;
                ret |= n & 1;
                n >>>= 1;
            }

            return ret;
        }
    }
}
