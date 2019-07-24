package com.company.Tree.recursive1;


import com.company.Tree.TreeNode;

/**
 * 统计路径和等于一个数的路径数量
 * 要求：
 * 难度：Easy
 * 第一次是否做出： 是, 但是效率只有 50%， 改进点在 pathSumCore 函数
 */
public class P7_437 {
    class Solution {
        private  int[] count = new int[1];
        public int pathSum(TreeNode root, int sum) {
            if(root == null){
                return 0;
            }

            count[0] = 0;
            pathSumCore(root, sum, count);
            return count[0] + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private void pathSumCore(TreeNode root, int sum, int[] count){
            if(root == null){
                return;
            }

            if(root.val == sum){
                count[0]++;
            }

            pathSumCore(root.left, sum - root.val, count);
            pathSumCore(root.right, sum - root.val, count);
        }
    }
}
