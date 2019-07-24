package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 * 树的高度
 * 要求:
 * 难度：　Easy
 * 第一次是否做出：是
 */
public class P1_104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
