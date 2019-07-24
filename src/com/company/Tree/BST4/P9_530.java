package com.company.Tree.BST4;


import com.company.Tree.TreeNode;

/**
 * 在二叉查找树中查找两个节点之差的最小绝对值
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 * 反思： 做题时一定要确定正确再提交，不要先试
 */
public class P9_530 {
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            int min = Integer.MAX_VALUE;
            if(root == null){
                return min;
            }


            if(root.left != null){
                min = Math.abs(root.val - getRight(root.left).val) < min ? Math.abs(root.val - getRight(root.left).val) : min;
            }

            if(root.right != null){
                min = Math.abs(root.val - getLeft(root.right).val) < min ? Math.abs(root.val - getLeft(root.right).val) : min;
            }

            return Math.min(min, Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));

        }

        private TreeNode getLeft(TreeNode node){
            if(node == null){
                return node;
            }

            while (node.left != null){
                node = node.left;
            }

            return node;

        }

        private TreeNode getRight(TreeNode node){
            if(node == null){
                return node;
            }

            while (node.right != null){
                node = node.right;
            }

            return node;
        }
    }
}
