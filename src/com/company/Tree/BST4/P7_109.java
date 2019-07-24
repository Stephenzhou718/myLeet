package com.company.Tree.BST4;


import com.company.List.ListNode;
import com.company.Tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 根据有序链表构造平衡的二叉查找树
 * 要求：
 * 难度：Medium
 * 第一次是否做出： 否
 * 反思： 链表和数组一样都是要找到中间的那个节点
 */
public class P7_109 {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }

            if(head.next == null) return new TreeNode(head.val);

            ListNode pre = preMid(head);
            ListNode mid = pre.next;
            pre.next = null;

            TreeNode node = new TreeNode(mid.val);
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(mid.next);
            return node;
        }


        private ListNode preMid(ListNode head){
            ListNode fast = head;
            ListNode slow = head;
            ListNode pre = head;
            while (fast != null && fast.next != null){
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            return pre;
        }
    }
}
