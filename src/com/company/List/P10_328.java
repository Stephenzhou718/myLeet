
package com.company.List;

/**
 * 链表元素按奇偶聚集,序号的奇偶而不是值的奇偶
 * 要求：
 * 第一次是否做出：是
 */
public class P10_328 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ret = new P10_328().new Solution().oddEvenList(head);
        while (ret != null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null){
                return null;
            }

            int count = 1;
            ListNode odd = new ListNode(-1);
            ListNode even = new ListNode(-1);
            ListNode pre = odd;
            ListNode last = even;

            while (head != null){
                if(count % 2 == 1){
                    //奇数顺序的节点
                    odd.next = head;
                    odd = odd.next;

                }else {
                    //偶数顺序的节点
                    even.next = head;
                    even = even.next;
                }

                ListNode now = head;
                head = head.next;
                now.next = null;
                count++;
            }

            odd.next = last.next;
            return pre.next;
        }
    }
}
