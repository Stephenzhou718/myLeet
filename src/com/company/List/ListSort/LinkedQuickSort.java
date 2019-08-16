package com.company.List.ListSort;

/**
 * 链表额快速排序
 */
public class LinkedQuickSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    public static ListNode quickSort(ListNode begin, ListNode end) {
        // 判断为空， 【判断是不是只有一个节点
        if (begin == null || end == null || begin == end) {
            return begin;
        }

        // 从第一个节点和第一个节点的后面一个节点
        // begin 指向的是当前遍历到最后一个 <= nMindValue 的节点
        ListNode first = begin;
        ListNode second = begin.next;

        int nMinValue = first.val;

        // 结束条件，second 到最后了
        while (second != end.next && second != null) {
            // 一直往后寻找 <= nMindValue 的节点，然后与 first 的后继节点交换
            if (second.val < nMinValue) {
                first = first.next;

                // 判断一下，避免后面的数比第一个数小，不用换的局面
                if (first != second) {
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
            }

            second = second.next;
        }

        // 判断，有些情况是不用换的，提升性能
        if (begin != first) {
            int temp = begin.val;
            begin.val = first.val;
            first.val = temp;
        }


        // 前部分递归
        quickSort(begin, first);

        //后部分递归
        quickSort(first.next, end);
        return begin;
    }
}
