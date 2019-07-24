package com.company.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算一组字符集和可以组成的回文字符串的最大长度
 * 要求：
 * 难度：Easy
 * 第一次是否做出： 否，写出的程序有 bug
 * 反思： 一定要自己先写足够的测试用例， 回文字符串是几对可以对应的字符，再加一个单个的字符
 *       在有用到使用 HashMap 记录 26 个字符的长度的时候，要记住可以使用 26 位长的数组代替
 */
public class P5_409 {
    public static void main(String[] args){
        System.out.println(new P5_409().new Solution().longestPalindrome("cccabbbbb"));
    }
    class Solution {
        public int longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }

            HashMap<Character, Integer> sMap = new HashMap<>();
            for (char c : s.toCharArray()){
                if(!sMap.containsKey(c)){
                    sMap.put(c, 1);
                }else {
                    sMap.put(c, sMap.get(c) + 1);
                }
            }

            int singleNum  = 0;
            int doubleNum = 0;

            for (Map.Entry<Character, Integer> entry : sMap.entrySet()){
                if(entry.getValue() == 1 && singleNum != 1){
                    singleNum = 1;
                }

                if(entry.getValue() % 2 == 0){
                    doubleNum += entry.getValue();
                }else {
                    doubleNum += entry.getValue() - 1;
                    singleNum = 1;
                }
            }

            return singleNum + doubleNum;

        }
    }

    class Solution2{
        public int longestPalindrome(String s) {
            int[] cnts = new int[256];
            for(char c : s.toCharArray()){
                cnts[c] += 1;
            }

            int singleNum = 0;
            int doubleNum = 0;

            for(int i = 0; i < 256; i++){
                if(cnts[i] % 2 == 0){
                    doubleNum += cnts[i];
                }else {
                    doubleNum += cnts[i] - 1;
                    singleNum = 1;
                }
            }

            return doubleNum + singleNum;
        }
    }
}
