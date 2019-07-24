package com.company.ArrayAndMatrix;

/**
 * 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
 * 要求：
 * 难度：Easy
 * 第一次是否做出L：是
 * 反思：这种从 1 到 n 的连续序列问题，可以用连续的数组存储，错位的数字一下就可以看出
 */
public class P6_645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            if(nums == null || nums.length == 0) return new int[2];

            int[] inOrder = new int[nums.length];
            int[] ret = new int[2];

            for(int num : nums){
                inOrder[num - 1]++;
            }

            for(int i = 0; i < nums.length; i++){
                if(inOrder[i] == 1){
                    continue;
                }else if (inOrder[i] == 2){
                    ret[0] = i+1;
                }else if (inOrder[i] == 0){
                    ret[1] = i+1;
                }
            }
//            System.out.println("i");
            return ret;
        }
    }
}
