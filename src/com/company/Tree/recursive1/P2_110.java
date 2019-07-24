package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 平衡树
 * 要求:
 * 难度： Easy
 * 第一次是否做出:是
 */
public class P2_110 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }

            return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        }

        private int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
