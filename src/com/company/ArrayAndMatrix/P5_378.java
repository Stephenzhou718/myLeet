package com.company.ArrayAndMatrix;

import java.util.PriorityQueue;

/**
 * 有序矩阵中第 k 小的树
 * 要求：
 * 难度：
 * 第一次是否做出：否
 * 反思：有的排序问题可以用最小堆，最大堆来替换
 */
public class P5_378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            if(matrix == null || matrix.length == 0 || k > matrix.length * matrix[0].length || k < 0){
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            // 默认就是小顶堆
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    queue.offer(matrix[i][ j]);
                }
            }

            int ret = 0;
            for(int i = 0; i < k; i++){
                ret = queue.poll();
            }

            return ret;
        }
    }
}
