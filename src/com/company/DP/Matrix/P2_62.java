package com.company.DP.Matrix;

/**
 * 矩阵的总路径数
 * 要求：从左上角到右下角的总路径数，只能向右或者向下运动
 * 难度：Medium
 * 第一次是否做出：是，但是空间效率不高
 */
public class P2_62 {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else if (i == 0){
                    dp[i][j] = dp[i][j - 1];
                }else if (j == 0){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                }

            }
        }

        return dp[m - 1][n - 1];
    }
}
