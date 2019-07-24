package com.company.Hash;

import java.util.TreeSet;

/**
 * 判断数组是否含有重复元素
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P2_217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if(nums == null || nums.length == 0){
                return false;
            }

            TreeSet<Integer> set = new TreeSet<>();
            for(int i : nums){
                set.add(i);
            }
            return nums.length < set.size();
        }
    }
}
