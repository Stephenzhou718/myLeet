package com.company.Graph.SortGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 课程表的排序
 * 要求：
 * 难度：Medium
 * 第一次是否做出：
 */
public class P2_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graphic = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graphic[i] = new ArrayList<>();
            }
            for (int[] pre : prerequisites) {
                graphic[pre[0]].add(pre[1]);
            }
            Stack<Integer> postOrder = new Stack<>();
            boolean[] globalMarked = new boolean[numCourses];
            boolean[] localMarked = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(globalMarked, localMarked, graphic, i, postOrder)) {
                    return new int[0];
                }
            }
            int[] orders = new int[numCourses];
            for (int i = numCourses - 1; i >= 0; i--) {
                orders[i] = postOrder.pop();
            }
            return orders;
        }

        private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic,
                                 int curNode, Stack<Integer> postOrder) {

            if (localMarked[curNode]) {
                return true;
            }
            if (globalMarked[curNode]) {
                return false;
            }
            globalMarked[curNode] = true;
            localMarked[curNode] = true;
            for (int nextNode : graphic[curNode]) {
                if (hasCycle(globalMarked, localMarked, graphic, nextNode, postOrder)) {
                    return true;
                }
            }
            localMarked[curNode] = false;
            postOrder.push(curNode);
            return false;
        }
    }
}
