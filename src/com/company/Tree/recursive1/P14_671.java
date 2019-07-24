package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 找出二叉树中第二小的节点
 * 要求：
 * 难度： Easy
 * 第一次是否做出：否
 * 反思：把上一层树的问题转化为左子树或者右子树的问题
 */

public class P14_671 {
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            if(root == null) return -1;
            if(root.left == null && root.right == null) return -1;
            int leftVal = root.left.val;
            int rightVal = root.right.val;

            if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
            if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
            if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
            if(leftVal != -1) return leftVal;
            return rightVal;
        }
    }
}
