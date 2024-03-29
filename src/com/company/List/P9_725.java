package com.company.List;


import java.util.ArrayList;

/**
 * 分割链表， 把一个链表分割为 k 个部分
 * 要求：
 * 第一次是否做出：否
 */
public class P9_725 {
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int N = 0;
            ListNode cur = root;

            while (cur != null){
                N++;
                cur = cur.next;
            }

            int mod = N % k;
            int size  = N / k;

            ListNode[] ret = new ListNode[k];
            cur = root;

            for(int i = 0; cur != null && i < k; i++) {
                ret[i] = cur;
                int curSize = size + (mod-- > 0 ? 1 : 0);
                for (int j = 0; j < curSize - 1; j++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;

            }

            return ret;
        }
    }
}
