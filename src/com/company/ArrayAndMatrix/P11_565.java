package com.company.ArrayAndMatrix;

import sun.reflect.generics.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * 嵌套数组
 * 要求：
 * 难度：Medium
 * 第一次是否做出：是，但是时间超时
 * 反思：遍历的时候，可以记住之前便利的状态
 */
public class P11_565 {
    public static void main(String[] args){
        System.out.println(new P11_565().new Solution2().arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
    class Solution {
        public int arrayNesting(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int maxSize = 0;
            Set<Integer> set = new TreeSet<>();

            int nextIndex;
            for(int i = 0; i < nums.length; i++){
                set.clear();
                int preSize = 0;
                nextIndex = nums[i];
                set.add(nums[i]);

                while (set.size() > preSize){
                    preSize = set.size();
                    set.add(nums[nextIndex]);
                    nextIndex = nums[nextIndex];
                }

                if(set.size() > maxSize){
                    maxSize = set.size();
                }

            }

            return maxSize;

        }
    }

    class Solution2{
        public int arrayNesting(int[] nums) {
            int max = 0;

            for(int i = 0; i < nums.length; i++){
                int cnt = 0;

                for(int j = i; nums[j] != -1;){
                    cnt++;
                    int t = nums[j];
                    nums[j] = -1;
                    j = t;
                }
                max = Math.max(max, cnt);
            }

            return max;
        }
    }
}
