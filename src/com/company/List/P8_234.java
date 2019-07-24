package com.company.List;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.Stack;

/**
 * 回文链表
 * 要求： o(n) 的时间， o(1) 的空间
 * 第一次是否做出：否
 */
public class P8_234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null){
                return  true;
            }

            Stack<Integer> stack = buildStack(head);
            while (head != null && !stack.isEmpty()){
                if(head.val != stack.pop()){
                    return false;
                }

                head = head.next;
            }
            return true;

        }

        private Stack<Integer> buildStack(ListNode node){
            Stack<Integer> stack = new Stack<>();
            while (node != null){
                stack.push(node.val);
                node = node.next;
            }
            return stack;
        }
    }
}
