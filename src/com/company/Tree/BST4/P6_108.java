package com.company.Tree.BST4;

import com.company.Tree.TreeNode;

/**
 * 从有序数组中构造二叉查找树
 * 要求：
 * 难度： Easy
 * 第一次是否做出：是
 * 反思： 递归构建二叉树的时候，先构造根节点再递归构造左子节点和右子节点
 */

class P6_108{
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortArrayToBSTCore(nums, 0, nums.length-1);
        }

        private TreeNode sortArrayToBSTCore(int[] nums, int begin, int end){
            if(nums == null || nums.length == 0){
                return null;
            }

            if(begin > end){
                return null;
            }

            int mid = (begin + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortArrayToBSTCore(nums, begin, mid-1);
            node.right = sortArrayToBSTCore(nums, mid + 1, end);
            return node;
        }
    }

}
