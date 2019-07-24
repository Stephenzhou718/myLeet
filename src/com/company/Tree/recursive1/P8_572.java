package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 * 子树
 * 要求：
 * 难度：Easy
 * 是否第一次做出：否，第 22 行调用错函数，昏了头
 */
public class P8_572 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(t == null){
                return true;
            }

            if(s == null){
                return false;
            }else {
                return isEqualTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        }


        private boolean isEqualTree(TreeNode t1, TreeNode t2){
            if(t1 == null && t2 == null){
                return true;
            }

            if(t1 != null && t2 != null){
                return t1.val == t2.val && isEqualTree(t1.left, t2.left) && isEqualTree(t1.right, t2.right);
            }

            return false;
        }
    }
}
