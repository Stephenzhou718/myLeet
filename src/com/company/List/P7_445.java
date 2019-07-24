package com.company.List;


import java.util.Stack;

/**
 * 链表求和
 * 要求： 不允许反转链表
 * 第一次是否做出：否
 */
public class P7_445 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode result = new P7_445().new Solution().addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack stack1 = buildStack(l1);
            Stack stack2 = buildStack(l2);

            ListNode head = new ListNode(-1);
            int carry = 0;

            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
                int val1 = stack1.isEmpty()? 0 : (int) stack1.pop();
                int val2 = stack2.isEmpty()? 0 : (int) stack2.pop();
                int sum = val1 + val2 + carry;
                carry = sum / 10;

                ListNode node = new ListNode(sum%10);
                node.next = head.next;
                head.next = node;
            }
            return head.next;
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
