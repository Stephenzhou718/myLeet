package com.company.Tree.BST4;

import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 寻找二叉查找树中出现次数最多的值
 * 要求：尽量不使用额外空间
 * 难度：Easy
 * 第一次是否做出：否，超时了
 * 反思： 尽量在现有的结构上操作，不要增加新结构或新运算
 */
public class P10_501 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(new P10_501().new Solution().findMode(root));
    }
    class Solution {
        private int curCnt = 1;
        private int maxCnt = 1;
        private TreeNode preNode = null;

        public int[] findMode(TreeNode root) {
            List<Integer> maxCntNums = new ArrayList<>();
            inOrder(root, maxCntNums);
            int[] ret = new int[maxCntNums.size()];
            int idx = 0;
            for(int num : maxCntNums){
                ret[idx++] = num;

            }
            return ret;

        }

        private void inOrder(TreeNode node, List<Integer> nums){
            if(node == null) return;

            inOrder(node.left, nums);
            if(preNode != null){
                if(preNode.val == node.val) curCnt++;
                else curCnt = 1;
            }

            if(curCnt > maxCnt){
                maxCnt = curCnt;
                nums.clear();
                nums.add(node.val);
            }else if(curCnt == maxCnt){
                nums.add(node.val);
            }

            preNode = node;
            inOrder(node.right, nums);
        }
    }

}
