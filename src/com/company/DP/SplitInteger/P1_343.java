package com.company.DP.SplitInteger;


/**
 * 分割整数，使得几个部分的乘积最大
 * 要求： 可以假设给出的 n 在 2 到 58 之间
 * 难度：Medium
 * 第一次是否做出： 是，利用贪心思想做出的，但是空间效率不高
 */
public class P1_343 {
    public static void main(String[] args){

    }



    class Solution {
        public int integerBreak(int n) {
            if(n == 2) {
                return 1;
            } else if ( n == 3) {
                return 2;
            } else {
                int i = n / 3;
                int j = n % 3;

                if(j == 1) {
                    return (int)Math.pow(3, i - 1) * 4;
                }else if(j == 0){
                    return (int)Math.pow(3, i);
                }else {
                    return (int)Math.pow(3, i) * j;
                }
            }
        }
    }


    /**
     * 解法 2 ， 网上解法
     */
    class Solution2{
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
                }
            }
            return dp[n];
        }
    }
}
