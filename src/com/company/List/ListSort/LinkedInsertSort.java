package com.company.List.ListSort;

/**
 * 链表的插入排序
 */
public class LinkedInsertSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = head; // pre 指向已经有序的节点
        ListNode cur = head.next; // cur 指向待排序的节点

        ListNode aux = new ListNode(-1);
        aux.next = head;

        while (cur != null) {
            if(cur.val < pre.val) {
                // 先把 cur 节点删除掉， 然后再把 cur 节点插到合适的位置
                pre.next = cur.next;

                ListNode l1 = aux;
                ListNode l2 = aux.next;

                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }

                // 把 cur 节点插入到 1 和 2 之间
                l1.next = cur;
                cur.next = l2; // 插入合适的位置

                cur = pre.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }

        return aux.next;
    }
}
