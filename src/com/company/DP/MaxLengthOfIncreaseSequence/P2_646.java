package com.company.DP.MaxLengthOfIncreaseSequence;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * 一对整数能够构成的最长链
 * 要求：
 * 难度：Medium
 * 第一次是否做出： 否，出了点小错（进行 dp 之前没有对 pairs 进行排序）
 */
public class P2_646 {
    public static void main (String[] args) {
        System.out.println((new int[][] {}).toString());
    }

    class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }

            int[] dp = new int[pairs.length];
            Arrays.fill(dp, 1);

            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0] - t1[0];
                }
            });

            for(int i = 0; i < pairs.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int ret = 0;
            for(int i = 0; i < pairs.length; i++) {
                ret = Math.max(ret, dp[i]);
            }

            return ret;
        }

    }
}
