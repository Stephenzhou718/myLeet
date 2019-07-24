package com.company.Hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中两个数的和为给定值
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 * 反思：一般用 Hash表可以达到用空间节省时间的目的
 */
public class P1_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> indexForNum = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(indexForNum.containsKey(target - nums[i])){
                    return new int[]{indexForNum.get(target - nums[i]), i};
                }else {
                    indexForNum.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
