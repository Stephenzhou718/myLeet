package com.company.StackAndQueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 要求：
 * 难度: Easy
 * 第一次是否做出：否
 * 反思： 忘记思想了，
 */
public class P2_225 {
    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();


        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            int cnt = queue.size();
            while (cnt-- > 1){
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
