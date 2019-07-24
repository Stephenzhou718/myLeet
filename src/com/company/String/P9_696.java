package com.company.String;

/**
 * 统计二进制字符串中连续 1 和 连续 0 数量相同的子字符串个数
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 * 反思：以后读题一定要读清楚
 */
public class P9_696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            int preLen = 0, curlen = 0, count = 0;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(i-1)){
                    curlen++;
                }else {
                    preLen = curlen;
                    curlen =1;
                }

                if(preLen >= curlen){
                    count++;
                }
            }
            return count;
        }
    }
}
