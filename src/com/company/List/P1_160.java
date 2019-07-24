package com.company.List;


/**
 * 求出两个链表的交点
 * 通过 if - else 的赋值语句可以用三目运算符来替代， 速度会快很多
 */
public class P1_160 {
    public class Solution{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB){
            //鲁棒性检测
            if(headA == null || headB == null){
                return null;
            }

            ListNode P1 = headA;
            ListNode P2 = headB;

            while (P1 != P2){
                P1 = P1 == null ? headB:P1.next;
                P2 = P2 == null ? headA:P2.next;
            }

            return P1;
        }
    }
}
