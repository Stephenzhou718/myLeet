package com.company.String;

/**
 * 判断一个整数是否是回文数
 * 要求：不能把数字转换成字符串
 * 难度：Easy
 * 第一次是否做出：否，没有考虑到中间连续为 0 的状况
 */
public class P8_9 {
    public static void main(String[] args){
        System.out.println(new P8_9().new Solution().isPalindrome(1000021));
    }


    class Solution {
        public boolean isPalindrome(int x) {
            if(x == 0){
                return true;
            }else if(x < 0 || x%10 == 0){
                return false;
            }else {
                int right = 0;
                while (x > right){
                    right = right * 10 + x % 10;
                    x /= 10;
                }

                return x == right || x == right / 10;
            }
        }
    }
}
