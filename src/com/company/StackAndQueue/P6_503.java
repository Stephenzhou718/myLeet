package com.company.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 循环数组中比当前元素大的下一个元素
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否
 * 反思：队列和栈总是 关联在一起的
 */
public class P6_503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] next = new int[n];
            Arrays.fill(next, -1);
            Stack<Integer> pre = new Stack<>();
            for(int i = 0; i <  n*2; i++){
                int num = nums[i % n];
                while (!pre.isEmpty() && nums[pre.peek()] < num){
                    next[pre.pop()] = num;
                }

                if(i < n){
                    pre.push(i);
                }
            }
            return next;


        }
    }

}
