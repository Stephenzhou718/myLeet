package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 两节点的最长路径
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是，但效率不高
 */
public class P3_543 {
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }

            int max = Math.max(nodeWeirht(root), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
            return max;

        }


        /**
         * 一个节点的最长路径
         * @param node
         * @return
         */
        private int nodeWeirht(TreeNode node){
            if(node == null){
                return 0;
            }

            return maxDepth(node.left) + maxDepth(node.right);
        }


        private int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }


    class Solution2{
        private int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return max;
        }

        private int depth(TreeNode root){
            if(root == null) return 0;
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            max = Math.max(max, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
