package com.company.Tree.traverse3;

import com.company.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现二叉树的中序遍历
 * 要求：非递归实现
 * 难度：Medium
 * 第一次是否做出： 是
 * 反思： 栈 ＋ 把有子树的节点转换成无子树的节点加入栈中
 */
public class p3_94 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
    }


    class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if(root == null){
                return ret;
            }

            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node.left == null && node.right == null){
                    ret.add(node.val);
                    continue;
                }


                if(node.right != null){
                    stack.push(node.right);
                }

                stack.push(new TreeNode(node.val));

                if(node.left != null){
                    stack.push(node.left);
                }
            }

            return ret;
        }
    }
}
