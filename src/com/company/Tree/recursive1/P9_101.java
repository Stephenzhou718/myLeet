package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 * 树的对称
 * 要求：
 * 难度：Easy
 * 第一次是否做出： 是
 */
public class P9_101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }

            if(root.left == null && root.right == null){
                return true;
            }

            if(root.left != null && root.right != null){
                return isSymmetricCore(root.left, root.right);
            }

            return false;
        }

        public boolean isSymmetricCore(TreeNode t1, TreeNode t2){
            if(t1 == null && t2 == null){
                return true;
            }

            if(t1 != null && t2 != null){
                return t1.val == t2.val && isSymmetricCore(t1.left, t2.right) && isSymmetricCore(t1.right, t2.left);
            }

            return false;
        }



    }
}
