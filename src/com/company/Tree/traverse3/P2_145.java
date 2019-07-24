package com.company.Tree.traverse3;

import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 非递归实现二叉树的后序遍历、
 * 要求：不能用递归
 * 难度： Medium
 * 第一次是否做出：
 */
public class P2_145 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ret = new ArrayList<>();
        ret = new P2_145().new Solution().postorderTraversal(root);
        for(int i : ret){
            System.out.println(i);
        }

    }
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
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

                stack.push(new TreeNode(node.val));
                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);


            }
            return ret;
        }
    }


    /**
     * 解法二： 把前序遍历反一下，左右节点的顺序也会反一下
     */
    class Solution2{


        public List<Integer> postorderTraversal(TreeNode root){
            List<Integer> ret = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node == null) continue;;
                ret.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }

            Collections.reverse(ret);
            return ret;
        }
    }
}
