package com.company.String;

/**
 * 回文子字符串个数
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否
 * 反思：回文串就是从中间开始对应的，这个统计回文串个数可以从中间开始扩展
 */
public class P7_647 {
    class Solution {
        private int cnt = 0;
        public int countSubstrings(String s) {
            for(int i = 0; i < s.length(); i++){
                extendSubStrings(s, i, i);          //长度为奇数的子串
                extendSubStrings(s, i , i+1);  //长度为偶数的子串
            }
            return cnt;
        }

        private void extendSubStrings(String s, int begin, int end){
            while (begin >= 0 && end < s.length() &&(s.charAt(begin) == s.charAt(end))){
                begin--;
                end++;
                cnt++;
            }
        }
    }
}
