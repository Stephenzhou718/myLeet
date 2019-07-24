package com.company.List;


/**
 * 反转链表
 * 要点：链表反转记得要用三个指针
 */

public class P2_206 {
    class Solution{
        public ListNode reverseList(ListNode head){
            if(head == null){
                return null;
            }

            ListNode pre = null;
            ListNode per = head;
            ListNode next = head.next;

            while (next != null){
                per.next = pre;
                pre = per;
                per = next;
                next = next.next;
            }
            per.next = pre;

            return per;
        }
    }
}
