package com.company.List;


/**
 * 从有序链表中删除重复节点
 */
public class P4_83 {
    class Solution{
        public ListNode deleteDuplicates(ListNode head){
            if(head == null){
                return null;
            }

            ListNode per = head;
            while (per.next != null){
                if(per.val == per.next.val){
                    per.next = per.next.next;
                }else {
                    per = per.next;
                }

            }
            return head;
        }
    }
}
