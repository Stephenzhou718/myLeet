package com.company.Tree.BST4;

import com.company.Tree.TreeNode;

/**
 * 修建二叉查找树
 * 要求：
 * 难度： Easy
 * 第一次是否做出：是
 */
public class P1_669 {
    class Solution{
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null){
                return null;
            }

            if(root.val < L){
                return trimBST(root.right, L, R);
            }

            if(root.val > R){
                return trimBST(root.left, L, R);
            }

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

}
