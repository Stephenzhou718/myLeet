package com.company.Bit;

/**
 * 判断一个数是不是 4 的 n 次方
 * 要求： 不能用循环或者递归
 * 难度：Easy
 * 第一次是否做出： 否， 卡在了怎么判断奇数位的 1
 */
public class P8_342 {
    class Solution {
        public boolean isPowerOfFour(int num) {
            if(num <= 0){
                return false;
            }

            if((num & num - 1) != 0){
                return false;
            }else {
                return (num & 0b01010101010101010101010101010101) != 0;
            }
        }

    }
}
