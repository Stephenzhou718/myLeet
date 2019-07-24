package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 间隔便利
 * 要求:
 * 难度：Medium
 * 第一次是否做出: 否, 要注意不是隔一层区一层的
 */
public class P13_337 {
    class Solution {

        public int rob(TreeNode root) {
            return robFirst(root);

        }

        private int robFirst(TreeNode root){
            if(root == null){
                return 0;
            }


            int val = root.val;
            if(root.left != null) val += robFirst(root.left.left) + robFirst(root.left.right);
            if(root.right != null) val += robFirst(root.right.left) + robFirst(root.right.right);

            int val2 = robFirst(root.left) + robFirst(root.right);
            return Math.max(val, val2);

        }

    }
}
