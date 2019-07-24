package com.company.StackAndQueue;

import java.util.Stack;

/**
 * 最小值栈
 * 要求：
 * 难度：Easy
 * 第一次是否做出：
 */
public class P3_155 {
    class MinStack{
        Stack<Integer> stack1 = new Stack<>();    // 正常的栈
        Stack<Integer> stack2 = new Stack<>();    // 对应最小数的栈
        int min = Integer.MAX_VALUE;              // 对应当前的最小数


        public MinStack(){

        }

        public void push(int x){
            stack1.push(x);
            if(x < min){
                min = x;
            }
            stack2.push(min);
        }

        public void pop(){
            stack1.pop();
            stack2.pop();

            if(stack2.isEmpty()){
                min = Integer.MAX_VALUE;
            }else {
                min = stack2.peek();
            }
        }

        public int top(){
            return stack1.peek();
        }

        public int getMin(){
            return stack2.peek();
        }
    }
}
