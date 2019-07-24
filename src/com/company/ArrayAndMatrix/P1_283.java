package com.company.ArrayAndMatrix;

import java.util.Arrays;

/**
 * 把数组中的 0 移到末尾
 * 要求：保持非零元素的相对顺序不变
 * 难度：Easy
 * 第一次是否做出：是，不过有很多 bug，
 * 反思：逻辑要清楚，测试用例要全面
 */
public class P1_283 {
    public static void main(String[] args){
        int[] ret = {1,0,1};
        new P1_283().new Solution().moveZeroes(ret);
        for(int i : ret){
            System.out.println(i);
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            if(nums == null || nums.length == 0){
                return;
            }
           int begin = 0;
           for(int i = 0; i < nums.length; i++){
               if(nums[begin] != 0){
                   begin++;
                   continue;
               }

               if(nums[i] != 0 && begin != i){
                   nums[begin] = nums[i];
                   nums[i] = 0;
                   begin++;
               }
           }
        }
    }
}
