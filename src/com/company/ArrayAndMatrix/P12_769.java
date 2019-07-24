package com.company.ArrayAndMatrix;

/**
 * 分隔数组
 * 要求：使分割后对每部分进行排序之后，数组就成为有序
 * 难度：Medium
 * 第一次是否做出：否
 */
public class P12_769 {
    public static void main(String[] args){
        System.out.println(new P12_769().new Solution().maxChunksToSorted(new int[]{1,2,0,3}));
        System.out.println(new P12_769().new Solution().maxChunksToSorted(new int[]{1,0,2,3,4}));
    }

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            if(arr == null) return 0;
            int ret = 0;
            int right = arr[0];
            for(int i = 0; i < arr.length; i++){
                right = Math.max(right, arr[i]);
                if(right == i) ret++;
            }

            return ret;
        }
    }
}
