package com.company.List;

/**
 * 交换链表中的相邻节点
 */
public class P6_24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null){
                return null;
            }

            if(head.next == null){
                return head;
            }

            ListNode next = head.next;
            ListNode nextHead = head.next.next;

            next.next = head;
            head.next = swapPairs(nextHead);
            return next;
        }
    }
}
