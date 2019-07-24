package com.company.Tree.level2;

import com.company.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找出二叉树的最底层最左边的节点
 * 要求：
 * 难度 Medium
 * 第一次是否做出：是
 * 反思： 树的层次便利问题要充分使用队列 Queue 以及记录一下下一层的节点数 cnt
 */
public class P2_513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                int cnt = queue.size();
                int nextCnt = 0;
                TreeNode first = queue.peek();
                for (int i = 0; i < cnt; i++){
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.add(node.left);
                        nextCnt++;
                    }

                    if(node.right != null){
                        queue.add(node.right);
                        nextCnt++;
                    }
                }
                if(nextCnt == 0){
                    return first.val;
                }

            }
            return 0;
        }
    }
}
