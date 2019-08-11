package com.company.DoublePoint;

import java.util.HashSet;

/**
 * 翻转字符串中的元音字符
 * 要求：元音字符为 a, e, i, o, u
 * 难度：Easy
 * 第一次是否做出：否，太粗心了，没有判断好边界
 */
public class P3_345 {
    public static void main(String[] args) {
        System.out.println(new P3_345().new Solution().reverseVowels("hello"));
    }

    class Solution {
        public String reverseVowels(String s) {
            if(s == null || s.length() < 2) {
                return s;
            }
            HashSet<Character> cSet = new HashSet<>();
            cSet.add('a');
            cSet.add('e');
            cSet.add('i');
            cSet.add('o');
            cSet.add('u');
            cSet.add('A');
            cSet.add('E');
            cSet.add('I');
            cSet.add('O');
            cSet.add('U');




            char[] c = s.toCharArray();
            int left = 0;
            int right = c.length - 1;

            while (left < right) {
                while (!cSet.contains(c[left]) && left < c.length - 1){
                    left++;
                }

                while (!cSet.contains(c[right]) && right > 0) {
                    right--;
                }

                if(left >= right){
                    break;
                }
                if(cSet.contains(c[left]) && cSet.contains(c[right])){
                    swapChar(c, left, right);
                    left++;
                    right--;
                }
            }

            return new String(c);
        }


        private void swapChar(char[] c, int left, int right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
        }
    }
}
