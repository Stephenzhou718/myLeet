package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 相同节点值的最大路径长度
 * 要求：
 * 难度：Easy
 * 第一次是否做出:否，要从这道题学到 dfs 想
 */
public class P12_687 {
    class Solution {
        private int maxPath = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return maxPath;
        }

        private int dfs(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);

            int leftPath = root.left != null && root.left.val == root.val? 1 + left : 0;
            int rightPath = root.right != null && root.right.val == root.val? 1 + right : 0;

            maxPath = Math.max(maxPath, leftPath + rightPath);
            return Math.max(leftPath, rightPath);
        }
    }
}
