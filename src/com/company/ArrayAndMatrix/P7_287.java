package com.company.ArrayAndMatrix;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 找出数组中重复的数字，数组织在 [1, n] 之间
 * 要求：空间在 O（1）， 时间在 O(n2) 内
 * 难度：Medium
 * 第一次是否做出：是， 但是修改了数组
 */
public class P7_287 {
    public static void main(String[] agrs){
        System.out.println(new P7_287().new Solution().findDuplicate(new int[]{1,3,4,2,2}));
    }
    class Solution {
        public int findDuplicate(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            Arrays.sort(nums);

            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= i){
                    return nums[i];
                }
            }
            return 0;
        }
    }
}
