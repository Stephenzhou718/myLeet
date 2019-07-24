package com.company.StackAndQueue;

import java.util.Stack;

/**
 * 用栈实现括号匹配
 * 要求：
 * 难度：Easy
 * 第一次是否做出：
 */
public class P4_20 {
    public static void main(String[] args){
        String s = "(){}[]";
        System.out.println(new P4_20().new Solution().isValid(s));
    }

    class Solution {
        Stack<Character> stack = new Stack<>();
        public boolean isValid(String s) {
            if(s == null || s.length() == 0){
                return true;
            }

            for(int i = 0; i < s.length(); i++){
                if(!stack.isEmpty() && isMatch(stack.peek(), s.charAt(i))){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }

            return stack.isEmpty();
        }

        private boolean isMatch(Character a, Character b){
            if(a == '(') return b == ')';
            if(a == '{') return b == '}';
            if(a == '[') return b == ']';
            return false;
        }
    }
}
