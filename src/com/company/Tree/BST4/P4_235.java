package com.company.Tree.BST4;

import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 二叉查找树的最近公共祖先
 * 要求：
 * 难度：Easy
 * 第一次是否做出： 是，但效率很低。没有用到二叉查找树的特性
 */
public class P4_235 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode ret = new P4_235().new Solution().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(ret.val);
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            if(root.val == p.val && (isInTree(root.left, q) || isInTree(root.right, q))) return root;
            if(root.val == q.val && (isInTree(root.left, p) || isInTree(root.right, p))) return root;
            if( (isInTree(root.left, p) && isInTree(root.right,q)) || (isInTree(root.left, q) && isInTree(root.right, p))) return root;
            if(p.val < root.val) return lowestCommonAncestor(root.left, p, q);
            return lowestCommonAncestor(root.right, p, q);
        }

        private boolean isInTree(TreeNode root, TreeNode target){
            if(root == null) return false;

            if(root.val == target.val) return true;
            return isInTree(root.left, target) || isInTree(root.right, target);
        }
    }

    class Solution2{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }

}
