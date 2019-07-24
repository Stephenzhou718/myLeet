package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 * 最小路径
 * 要求
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P10_111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            if(root.left == null && root.right == null){
                return 1;
            }

            if(root.left == null){
                return 1 + minDepth(root.right);
            }


            if(root.right == null){
                return 1 + minDepth(root.left);
            }

            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

}
