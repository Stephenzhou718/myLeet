package com.company.Graph.SortGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程安排的合法性
 * 要求：
 * 难度：Medium
 * 第一次是否做出：
 * 分析：判断连通图是否存在
 */
public class P1_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //  下面步骤为构建图
            List<Integer>[] graphic = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graphic[i] = new ArrayList<>();
            }
            for (int[] pre : prerequisites) {
                graphic[pre[0]].add(pre[1]);
            }


            boolean[] globalMarked = new boolean[numCourses];
            boolean[] localMarked = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(globalMarked, localMarked, graphic, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked,
                                 List<Integer>[] graphic, int curNode) {

            if (localMarked[curNode]) {
                return true;
            }
            if (globalMarked[curNode]) {
                return false;
            }

            globalMarked[curNode] = true;
            localMarked[curNode] = true;
            for (int nextNode : graphic[curNode]) {
                if (hasCycle(globalMarked, localMarked, graphic, nextNode)) {
                    return true;
                }
            }
            localMarked[curNode] = false;
            return false;
        }
    }
}
