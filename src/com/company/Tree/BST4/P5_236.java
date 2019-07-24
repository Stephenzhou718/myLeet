package com.company.Tree.BST4;


import com.company.Tree.TreeNode;

/**
 * 二叉树的额最低公共祖先
 * 要求：普通的二叉树，不是二叉查找树
 * 难度： Medium
 * 第一次是否做出： 是，但是效率并不高. 判断条件没有找好
 */
public class P5_236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            if(root.val == p.val && (isInTree(root.left, q) || isInTree(root.right, q))) return root;
            if(root.val == q.val && (isInTree(root.left, p) || isInTree(root.right, p))) return root;
            if( (isInTree(root.left, p) && isInTree(root.right,q)) || (isInTree(root.left, q) && isInTree(root.right, p))) return root;
            return isInTree(root.left, p)? lowestCommonAncestor(root.left,p, q): lowestCommonAncestor(root.right, p, q);
        }

        private boolean isInTree(TreeNode root, TreeNode target){
            if(root == null) return false;

            if(root.val == target.val) return true;
            return isInTree(root.left, target) || isInTree(root.right, target);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
