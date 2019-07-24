package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 *判断路径和是否等于一个数
 * 要求:
 * 难度：
 * 第一次是否做出：是
 */
public class P6_112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {

            if(root == null){
                return false;
            }

            if(root.val == sum && root.left ==null && root.right == null){
                return true;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
