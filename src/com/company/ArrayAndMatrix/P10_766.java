package com.company.ArrayAndMatrix;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 对角元素相等的矩阵
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是，但是时间超时了
 */
public class P10_766 {
    public static void main(String[] args){
        System.out.println(new P10_766().new Solution().isToeplitzMatrix(new int[][]{{11,74,0,93},{40,11,74,7}}));
    }
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return true;
            }

            int rowNum = matrix.length - 1;
            int colNum = matrix[0].length - 1;

            ArrayList<MatrixNode> list = new ArrayList<>();
            ArrayList<MatrixNode> nextList = new ArrayList<>();
            list.add(new MatrixNode(rowNum, 0, matrix[rowNum][0]));

            while (!list.isEmpty()){
                for(MatrixNode matrixNode : list){
                    if(matrixNode.row - 1 >= 0){
                        nextList.add(new MatrixNode(matrixNode.row -1, matrixNode.col, matrix[matrixNode.row - 1][matrixNode.col]));
                    }

                    if(matrixNode.col + 1 <= colNum){
                        nextList.add(new MatrixNode(matrixNode.row , matrixNode.col + 1, matrix[matrixNode.row][matrixNode.col + 1]));
                    }
                }

                Set<Integer> set = new TreeSet<>();
                for(MatrixNode node : nextList){
                    set.add(node.val);
                }

                if(set.size() > 1){
                    return false;
                }

                list = nextList;
                nextList = new ArrayList<>();
            }

            return true;

        }

        class MatrixNode{
             int row;
             int col;
             int val;

            public MatrixNode(int row, int col, int val){
                this.row = row;
                this.col = col;
                this.val = val;
            }
        }
    }


    class Solution2 {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for(int i = 0; i < matrix[0].length; i++){
                if(!check(matrix, matrix[0][i], 0, i)){
                    return false;
                }
            }

            for(int i = 0; i < matrix.length; i++){
                if(!check(matrix, matrix[i][0], i, 0)){
                    return false;
                }
            }

            return true;
        }

        private boolean check(int[][] matrix, int expectedValue, int row, int col){
            if(row >= matrix.length || col >= matrix[0].length){
                return true;
            }

            if(matrix[row][col] != expectedValue){
                return false;
            }

            return check(matrix, expectedValue, row + 1, col + 1);
        }
    }

}
