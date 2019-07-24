package com.company.Bit;

/**
 * 字符串数组的最大乘积
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否
 * 查看两个字符串中是否有相同字母， 可以用位的 ^ 运算
 */
public class P12_318 {
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] val = new int[n];

            for(int i = 0; i < n; i++){
                for (char c : words[i].toCharArray()){
                    val[i] |= 1 << (c - 'a');
                }
            }

            int ret = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if((val[i] & val[j]) == 0){
                        ret = Math.max(ret, words[i].length() * words[j].length());
                    }
                }
            }

            return ret;
        }
    }
}
