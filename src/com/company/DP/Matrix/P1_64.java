package com.company.DP.Matrix;

/**
 * 矩阵的最小路径
 * 要求：找一条路径从左上角到右下角距离最短
 * 难度：Medium
 * 第一次是否做出：否
 */
public class P1_64 {

    class Solution {
        public int minPathSum(int[][] grid) {
            if(grid.length == 0 || grid[0].length == 0){
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;

            int[] dp = new int[n];

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (j == 0){
                        dp[j] = dp[j];
                    }else if (i == 0){
                        dp[j] = dp[j - 1];
                    }else {
                        dp[j] = Math.min(dp[j], dp[j - 1]);
                    }

                    dp[j] += grid[i][j];
                }
            }

            return dp[n - 1];
        }
    }
}
