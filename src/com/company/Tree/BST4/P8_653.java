package com.company.Tree.BST4;

import com.company.List.ListNode;
import com.company.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二叉查找树中寻找两个节点，使它们的和为一个给定值
 *要求：
 * 难度： Easy
 * 第一次是否做出：否
 * 反思： 转化问题，把一颗二叉排序树转化为数组， 再利用双指针查找
 */
public class P8_653 {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> nums = new ArrayList<>();
            inOrder(root, nums);
            int i = 0;
            int j = nums.size() - 1;
            while (i < j){
                 int sum = nums.get(i) + nums.get(j);
                 if(sum == k) return true;
                 if(sum < k) i++;
                 if(sum > k) j--;
            }
            return false;


        }

        private void inOrder(TreeNode root, List<Integer> nums){
            if(root == null) return;
            inOrder(root.left, nums);
            nums.add(root.val);
            inOrder(root.right, nums);
        }
    }
}
