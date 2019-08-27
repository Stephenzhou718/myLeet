package com.company.DP.SplitInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按平方数来分割整数
 * 要求：用最少的平方数组合出给出的整数 n
 * 难度：Medium
 * 第一次是否做出： 是，但是时间效率和空间效率都很低
 */
public class P2_279 {
    public static void main(String[] args) {

        System.out.println(new P2_279().new Solution().numSquares(13));
    }

    class Solution {
        private int[] isSquare;
        public int numSquares(int n) {
            if(n <= 0) {
                return 0;
            }else {
                int[] dp = new int[n + 1];
                isSquare = new int[n + 1];
                Arrays.fill(isSquare, 2);
                for(int i = 1; i < n + 1; i++){
                    if(isSquareCore(i)) {
                        dp[i] = 1;
                    }else {
                        dp[i] = i;

                    }
                }

                for(int i = 1; i < n + 1; i++){
                    for(int j = i-1; j > 0; j--){
                        if(isSquareCore(i-j)) {
                            dp[i] = Math.min(dp[i], dp[j] + 1);
                        }
                    }
                }

//                for(int i = 1; i < n + 1; i++){
//                    System.out.println(dp[i]);
//                }

                return dp[n];
            }
        }

        private boolean isSquareCore(int num) {
            if(num <= 0) {
                return false;
            }

            if(isSquare[num] == 2) {
                isSquare[num] = (int)Math.sqrt(num) * (int)Math.sqrt(num) == num? 0:1;
            }

            return isSquare[num] == 0;
        }
    }


    /**
     * 网上解法
     * 和我的解法差不多， 优在了内层循环和判断一个数是不是完全平方数的部分
     */
    class Solution2 {
        public int numSquares(int n) {
            List<Integer> squareList = generateSquareList(n);
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int square : squareList) {
                    if (square > i) {
                        break;
                    }
                    min = Math.min(min, dp[i - square] + 1);
                }
                dp[i] = min;
            }
            return dp[n];
        }

        private List<Integer> generateSquareList(int n) {
            List<Integer> squareList = new ArrayList<>();
            int diff = 3;
            int square = 1;
            while (square <= n) {
                squareList.add(square);
                square += diff;
                diff += 2;
            }
            return squareList;
        }
    }
}
