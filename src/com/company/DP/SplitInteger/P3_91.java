package com.company.DP.SplitInteger;


/**
 * 分割整数构成字母字符串
 * 要求：
 * 难度：Medium
 * 第一次是否做出：
 */
public class P3_91 {
    public static void main(String[] args) {
        System.out.println(new P3_91().new Solution().numDecodings("2234231"));
    }


    /**
     * 这个 solution 没有做出来
     * 保留这个 solution 只是看一下当时思路
     */
    class Solution {
        public int numDecodings(String s) {
            if(s == null || s.length() == 0 || (s.equals(new String(new char[s.length()]).replace("\0", "0")))){
                return 0;
            }else if(s.length() == 1){
                return 1;
            }else if (s.length() == 2){
                if(Integer.valueOf(s) > 26 || s.charAt(1) == '0') {
                    return 1;
                }else {
                    return 2;
                }
            }

            int[] dp = new int[s.length()];
            dp[0] = 1;

            if(Integer.valueOf(s.substring(0, 2)) > 26 || s.charAt(1) == '0') {
                dp[1] = 1;
            }else {
                dp[1] = 2;
            }

            for(int i = 2; i < s.length(); i++) {
                if(s.charAt(i - 1) == '0' || s.charAt(i) == '0') {
                    dp[i] = dp[i -1];
                }else {
                    if(Integer.valueOf(s.substring(i-1,i+1)) > 26) {
                        dp[i] = dp[i - 1] + 1;

                    } else {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    }
                }

            }

            return dp[s.length() - 1];
        }
    }


    /**
     * 网上正确的 solution
     */
    class Solution2{
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 2; i <= n; i++) {
                int one = Integer.valueOf(s.substring(i - 1, i));
                if (one != 0) {
                    dp[i] += dp[i - 1];
                }
                if (s.charAt(i - 2) == '0') {
                    continue;
                }
                int two = Integer.valueOf(s.substring(i - 2, i));
                if (two <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}
