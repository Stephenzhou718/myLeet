package com.company.Graph.BinaryGraph;

import java.util.Arrays;

/**
 * 判断图是否为二分图
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否， 题都看不懂哦
 * 分析：如果可以用两种颜色对图中的节点进行着色，并且保证相邻的节点颜色不同，那么这个图就是二分图
 */
public class P1_785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] colors = new int[graph.length];
            Arrays.fill(colors, -1);
            for(int i = 0; i < graph.length; i++){
                if(colors[i] == -1 && !isBipartite(i, 0, colors, graph)){
                    return false;
                }
            }

            return true;

        }

        private boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph){
            if(colors[curNode] != -1){
                return colors[curNode] == curColor;
            }

            colors[curNode] = curColor;

            for(int nextNode : graph[curNode]){
                if(!isBipartite(nextNode, 1 - curColor, colors, graph)){
                    return false;
                }
            }

            return true;
        }
    }
}
