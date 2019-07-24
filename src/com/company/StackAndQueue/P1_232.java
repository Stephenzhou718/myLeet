package com.company.StackAndQueue;

import java.util.Stack;

/**
 * 用栈实现队列
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P1_232 {
    class MyQueue{

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        public MyQueue(){

        }

        public void push(int x){
            stack2.push(x);
        }

        public int pop(){
            if(stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }

            return stack1.pop();
        }

        public int peek(){
            if(stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            }

            return stack1.peek();
        }

        public boolean empty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
