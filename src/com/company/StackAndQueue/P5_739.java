package com.company.StackAndQueue;

import java.util.Stack;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 * 要求：
 * 难度：Easy
 * 第一次是否做出：是，但是效率很低
 */
public class P5_739 {
    public static void main(String[] args){
        int[] T = new int[]{73,74,75,71,69,72,76,73};
//        int[] T = new int[]{};
        int[] ret = new P5_739().new Solution().dailyTemperatures(T);
        for(Integer i : ret){
            System.out.println(i);
        }
    }
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if(T == null || T.length == 0){
                return new int[]{};
            }
            int[] ret = new int[T.length];

            for(int i = 0; i < T.length; i++){
                int length = 0;
                for(int j = i + 1; j < T.length; j++){
                    if(T[j] > T[i]){
                        length = j - i;
                        ret[i] = length;
                        break;
                    }
                }
            }
            return ret;
        }
    }

    class Solution2{
        public int[] dailyTemperatures(int[] temperatures){
            int n = temperatures.length;
            int[] dist = new int[n];
            Stack<Integer> indexs = new Stack<>();
            for(int curIndex = 0; curIndex < n; curIndex++){
                while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]){
                    int preIndex = indexs.pop();
                    dist[preIndex] = curIndex - preIndex;
                }

                indexs.add(curIndex);
            }
            return dist;
        }
    }


}
