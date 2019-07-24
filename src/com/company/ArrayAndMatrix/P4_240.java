package com.company.ArrayAndMatrix;

/**
 * 有序矩阵查找
 * 要求：
 * 难度：Medium
 * 第一次是否做出：是
 */
public class P4_240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0){
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;

            int i = 0;
            int j = col - 1;
            while (i < row && j >= 0){
                if(matrix[i][j] == target){
                    return true;
                }else if (matrix[i][j] > target){
                    j--;
                }else {
                    i++;
                }
            }
            return false;
        }
    }
}
