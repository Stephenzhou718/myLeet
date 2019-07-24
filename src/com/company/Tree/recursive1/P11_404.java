package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

import javax.swing.*;

/**
 * 统计左叶子节点的和
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P11_404 {
    class Solution {
        private int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }

            sumOfLeftLeavesCore(root);
            return sum;

        }

        private void sumOfLeftLeavesCore(TreeNode root){
            if(root == null){
                return;
            }

            if(root.left != null && isLeafNode(root.left)){
                sum += root.left.val;
            }

            sumOfLeftLeavesCore(root.left);
            sumOfLeftLeavesCore(root.right);
        }



        private boolean isLeafNode(TreeNode root){
//            if(root == null){
//                return false;
//            }
//

            return root.left == root.right && root.left == null;
        }
    }
}
