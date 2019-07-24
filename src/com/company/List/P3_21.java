package com.company.List;

/**
 * 归并两个有序链表
 */


public class P3_21 {
    class Solution{
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null && l2 == null){
                return null;
            }
            ListNode root = new ListNode(0);
            ListNode per = root;
            while (l1 != null || l2 != null){
                if(l1 != null && l2 != null){
                    if(l1.val < l2.val){
                        per.next = l1;
                        l1 = l1.next;
                    }else {
                        per.next = l2;
                        l2 = l2.next;
                    }
                    per = per.next;
                }else if(l1 != null){
                    per.next = l1;
                    l1 = l1.next;
                    per = per.next;
                }else {
                    per.next = l2;
                    l2 = l2.next;
                    per = per.next;
                }
            }

            return root.next;
        }
    }

}
