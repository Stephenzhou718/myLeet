package com.company.Tree.level2;

import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 一层树每层节点的平均数
 * 要求：
 * 难度：Easy
 * 第一次是否做出: 否
 * 反思： 树的层次遍历需要使用到队列, 且不需要使用递归， 使用循环就行了
 */
public class P1_637 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        System.out.println(new P1_637().new Solution().averageOfLevels(root));
    }
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
             List<Double> ret = new ArrayList<>();
             if(root == null) return ret;
             Queue<TreeNode> queue = new LinkedList<>();
             queue.add(root);
             while (!queue.isEmpty()){
                 int cnt =queue.size();
                 double sum = 0;
                 for (int i = 0; i < cnt; i++){
                     TreeNode node = queue.poll();
                     sum += node.val;
                     if(node.left != null) queue.add(node.left);
                     if(node.right != null)queue.add(node.right);
                 }
                 ret.add(sum / cnt);
             }
             return ret;
        }

    }
}
