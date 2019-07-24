package com.company.Tree.traverse3;

import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现二叉树的前序遍历
 * 要求：不能用递归来遍历
 * 难度： Medium
 * 第一次是否做出：是，但是过程很艰难
 * 反思：不用递归做树的遍历，就要用到栈，把要先打印的节点直接打印，需要最后打印的节点加入栈。
 */

public class P1_144 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ret = new P1_144().new Solution().preorderTraversal(root);
        for(int i : ret){
            System.out.println(i);
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if(root == null){
                return ret;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                TreeNode node1 = stack.pop();
                while (node1 != null){
                    ret.add(node1.val);
//                    if(node1.left != null){
//                        ret.add(node1.left.val);
//                    }

                    if(node1.right != null){
                        stack.push(node1.right);
                    }
                    node1 = node1.left;
                }

            }

        return ret;
        }
    }

    class Solution2{
        public List<Integer> preorderTraversal(TreeNode root){
            List<Integer> ret = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                ret.add(node.val);
                stack.push(root.right);
                stack.push(root.left);

            }
            return ret;
        }
    }

}
