package com.company.ArrayAndMatrix;

/**
 * 数组相邻差值的个数
 * 要求:
 * 难度：Medium
 * 第一次是否做出：否， 看不懂题目
 */
public class P8_667 {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] ret = new int[n];
            ret[0] = 1;

            for(int i = 1, interval = k; i <= k; i++, interval--){
                ret[i] = i % 2 == 1? ret[i - 1] + interval: ret[i - 1] - interval;
            }

            for(int i = k + 1; i < n; i++){
                ret[i] = i + 1;
            }

            return ret;
        }
    }
}
