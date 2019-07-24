package com.company.Tree.BST4;

import com.company.Tree.TreeNode;

/**
 * 寻找二叉树的第 k 个元素
 * 要求： k 的值默认符合要求
 * 难度：Medium
 * 第一次是否做出：是
 */
public class P2_230 {
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int[] num = new int[]{0};
            int[] ret = new int[]{-1};
            kthSmallestCore(root, k, num, ret);
            return ret[0];
        }

        public void kthSmallestCore(TreeNode root, int k, int[] num, int ret[]){
            if(root == null){
                return;
            }

            kthSmallestCore(root.left, k, num, ret);
            num[0]++;
            if(num[0] == k){
                ret[0] = root.val;
            }
            kthSmallestCore(root.right, k, num, ret);
        }
    }
}
