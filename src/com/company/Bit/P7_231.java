package com.company.Bit;

/**
 * 判断一个数是不是 2 的 n 次方
 * 要求:
 * 难度：Easy
 * 第一次是否做出：是，但是鲁棒性不够高，没有考虑到负数的情况
 */
public class P7_231 {
    public static void main(String[] args){
        System.out.println(new P7_231().new Solution().isPowerOfTwo(0));
        System.out.println(new P7_231().new Solution().isPowerOfTwo(4));
        System.out.println(new P7_231().new Solution().isPowerOfTwo(6));
    }
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if(n <= 0){
                return false;
            }
            int cnt = 0;
            while (n != 0){
                n &= n - 1;
                cnt++;
            }

            return cnt == 1;
        }
    }
}
