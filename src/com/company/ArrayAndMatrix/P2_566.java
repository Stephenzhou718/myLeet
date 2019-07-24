package com.company.ArrayAndMatrix;

/**
 * 改变矩阵维度
 * 要求：
 * 难度：
 * 第一次是否做出：
 */
public class P2_566 {
    public static void main(String[] args){
        int[][] ret = new P2_566().new Solution().matrixReshape(new int[][]{{1,2,3,4}}, 2, 2);
        for(int i = 0; i < ret.length; i++){
            for(int j = 0; j < ret[0].length; j++){
                System.out.println(ret[i][j]);
            }
            System.out.println("========");
        }
    }
    class Solution {

        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if(nums == null){
                return nums;
            }

            int row = nums.length;
            int col = nums[0].length;

            if(row * col != r*c){
                return nums;
            }

            int[][] ret = new int[r][c];
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    int mul = i * c + j + 1;

                    int oRow = mul / col;
                    int oCol = mul % col;

                    if(oCol == 0){
                        ret[i][j] = nums[oRow - 1][col - 1];
                    }else {
                        ret[i][j] = nums[oRow][oCol-1];
                    }
                }
            }
            return ret;
        }

    }
}
