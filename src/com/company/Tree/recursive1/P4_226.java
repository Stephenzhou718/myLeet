package com.company.Tree.recursive1;

import com.company.Tree.TreeNode;

/**　
 * 翻转树, 对称树
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P4_226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }

            TreeNode temp = root.left;

            root.left = invertTree(root.right);
            root.right = invertTree(temp);

            return root;
        }
    }
}
