package com.company.ArrayAndMatrix;

import java.util.*;

/**
 * 数组的度
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 */
public class P9_697 {
    public static void main(String[] args){
        System.out.println(new P9_697().new Solution().findShortestSubArray(new int[]{1,2,2,3,1}));
    }
    class Solution {
        public int findShortestSubArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int maxCnt = 0;
            ArrayList<Integer> list = new ArrayList<>();

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            HashMap<Integer, Integer> numsCount = new HashMap<>();
            Map<Integer, Integer> indexBegin = new HashMap<>();
            Map<Integer, Integer> indexEnd = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                if(!indexBegin.containsKey(nums[i])){
                    indexBegin.put(nums[i], i);
                }

                indexEnd.put(nums[i], i);

                if(!numsCount.containsKey(nums[i])){
                    numsCount.put(nums[i],1);
                }else {
                    numsCount.put(nums[i], numsCount.get(nums[i]) + 1);
                }
            }

            for(int key : numsCount.keySet()){
                if(numsCount.get(key) > maxCnt){
                    list.clear();
                    maxCnt = numsCount.get(key);
                    list.add(key);
                }else if (numsCount.get(key) == maxCnt){
                    list.add(key);
                }
            }

            for(int key : list){
                queue.offer(indexEnd.get(key) - indexBegin.get(key) + 1);
            }

            return queue.poll();
        }
    }
}
