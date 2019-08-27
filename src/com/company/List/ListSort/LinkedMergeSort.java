package com.company.List.ListSort;

/**
 * 链表的归并排序
 */
public class LinkedMergeSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);  // 获取链表的中间节点

        // 把链表从中间差费为两个链表： head 和 second 两个子链表
        ListNode second = mid.next;
        mid.next = null;

        // 对两个链表进行排序
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(second);

        return merge(left, head);
    }

    // 两个有序链表的合并
    private ListNode merge(ListNode l1, ListNode l2) {
        // 辅助节点，排好序的节点会连接到 dummy 后面
        ListNode dummpy = new ListNode(0);

        ListNode tail = dummpy;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummpy.next;
    }


    /**
     * 快慢指针来获得链表的中间节点
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode faster = head.next;

        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }

        return slow;
    }
}
