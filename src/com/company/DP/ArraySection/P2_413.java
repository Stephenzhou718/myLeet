package com.company.DP.ArraySection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 数组中等差底层自区间的个数
 * 要求：
 * 难度：Medium
 * 第一次是否做出：是，虽然调试的很艰难，而且时间效率也不高，但是做出来了
 * 反思：dp 问题需要先列出前几项找规律，然后看此项和前一项或者前两项有什么关系
 */
public class P2_413 {
    public static void main(String[] args){
        System.out.println(new P2_413().new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4,6,8}));


    }

    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            if(A == null || A.length < 3){
                return 0;
            }

            int[] dp = new int[A.length];


            int ret = 0;
            ArrayList<Integer> arithmetic = findArithmetic(A);
            int max = Collections.max(arithmetic);


            for(int i = 2; i < max; i++){
                dp[i] = dp[i - 1] + i - 1;
            }

            for(int i : arithmetic) {
//                System.out.println("i: " + i);
//                System.out.println(dp[i]);
                ret += dp[i - 1];
            }

            return ret;
        }


        private ArrayList<Integer> findArithmetic(int[] A) {
            ArrayList<Integer> ret = new ArrayList<>();

            int maxLength = 1;
            int diffLength = 0;
            boolean added = false;
            for(int i = 1; i < A.length; i++){
                int diff = A[i] - A[i - 1];


                if(maxLength == 1){
                    maxLength = 2;
                    diffLength = diff;
                }else {
                    if (diff == diffLength){
                        maxLength++;
                    }else {
                        maxLength = 1;
                        diffLength = 0;
                        added = false;
                        i--;
                    }
                }

                if(maxLength >= 3){
                    if (added) {
                        ret.set(ret.size() - 1, maxLength);
                    } else {
                        ret.add(maxLength);
                    }
                    added = true;
                }
            }

            return ret;
        }
    }


    /**
     * 改进的方法，
     * dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数
     * 当 A[i] - A[i-1] == A[i-1] - A[i-2]，那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，一样可以构成新的递增子区间
     * 综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。
     * 因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
     */
    class Solution2{
        public int numberOfArithmeticSlices(int[] A) {
            if (A == null || A.length == 0) {
                return 0;
            }
            int n = A.length;
            int[] dp = new int[n];
            for (int i = 2; i < n; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            int total = 0;
            for (int cnt : dp) {
                total += cnt;
            }
            return total;
        }
    }
}
