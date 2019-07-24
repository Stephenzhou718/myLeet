package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**
 * 归并两棵树
 * 要求：
 * 难度： Easy
 * 第一次是否做出：是
 */
public class P5_617 {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null){
                return null;
            }

            if(t1 != null && t2 == null){
                return t1;
            }

            if(t1 == null){
                return t2;
            }



            TreeNode ret = new TreeNode(t1.val + t2.val);
            ret.left = mergeTrees(t1.left, t2.left);
            ret.right = mergeTrees(t1.right, t2.right);
            return ret;

        }
    }
}
