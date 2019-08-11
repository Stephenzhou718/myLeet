package com.company.DoublePoint;


/**
 * 两数平方和
 * 要求：给定一个数，看这个数是否能用两个数的平方和凑出来, 给的整数为非负数
 * 难度：Easy
 * 反思： 在做平方运算的时候，直接用 a * a, 而不要用  Math.pow(a, 2), 因为用 Math 会慢很多
 */
public class P2_633 {

    public static void main(String[] args) {
        System.out.println(new P2_633().new Solution().judgeSquareSum(1));
    }

    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0;
            int right = (int) Math.sqrt(c);

            while (left <= right) {
//                int sum = (int) (Math.pow(left, 2) + Math.pow(right, 2));
                int sum = left * left + right * right;
                if(sum > c){
                    right--;
                } else if (sum == c){
                    return true;
                } else {
                    left++;
                }
            }

            return false;

        }
    }
}
