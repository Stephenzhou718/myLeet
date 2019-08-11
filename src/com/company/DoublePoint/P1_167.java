package com.company.DoublePoint;

/**
 * 有序数组的 Two Sum
 * 要求：索引从 1 开始，而不是从 0 开始
 * 难度：Easy
 * 第一次是否做出：是
 */
public class P1_167 {
    public static void main(String[] args){

    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] ret = new int[2];

            if(numbers == null || numbers.length < 2){
                return ret;
            }

            int index1 = 0;
            int index2 = numbers.length - 1;

            while (numbers[index1] + numbers[index2] != target){
                int sum = numbers[index1] + numbers[index2];

                if(sum < target){
                    index1++;
                }else {
                    index2--;
                }
            }

            ret[0] = index1 + 1;
            ret[1] = index2 + 1;


            return ret;
        }
    }
}
