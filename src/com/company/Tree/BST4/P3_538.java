package com.company.Tree.BST4;

import com.company.Tree.TreeNode;

/**
 * 把二叉查找树每个节点的值都加上比它大的节点的值
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 * 反思：从右子树先遍历
 *
 */
public class P3_538 {
    class Solution {
        private int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            traver(root);
            return root;
        }

        private void traver(TreeNode node){
            if(node == null){
                return;
            }

            traver(node.right);
            sum += node.val;
            node.val = sum;
            traver(node.left);
        }
    }
}
