package com.company.List;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * 删除链表的倒数第 n 个节点
 */
public class P5_19 {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);

        ListNode result = new P5_19().new Solution().removeNthFromEnd(head, 2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //鲁棒性检查
            if(head == null || n <= 0){
                return null;
            }


            ListNode l1 = head;
            ListNode l2 = head;


            for(int i = 0; i < n; i++){
                l2 = l2.next;
                if(l2 == null){
                    break;
                }
            }

            if(l2 == null){
                return head.next;
            }

            while (l2.next != null){
                l1 = l1.next;
                l2 = l2.next;
            }

            l1.next = l1.next.next;
            return head;
        }
    }
}
