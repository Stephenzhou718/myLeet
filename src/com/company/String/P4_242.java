package com.company.String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两个字符串中包含的字符是否完全相同
 * 要求：
 * 难度： Easy
 * 第一次是否做出：是，但是效率较低。
 * 反思： 哈希表和数组的效率问题，能用数组来进行计数的话就可以不用哈希表
 */
public class P4_242 {

    public static void main(String[] args){
//        System.out.println(new P4_242().new Solution().isAnagram("anagram", "nagaram"));
//        new P4_242().new Solution2().isAnagram();
    }
    class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            HashMap<Character, Integer> tMap = new HashMap<>();

            for(char c : s.toCharArray()){
                if(!sMap.containsKey(c)){
                    sMap.put(c, 1);
                }else {
                    sMap.put(c, sMap.get(c) + 1);
                }
            }

            for(char c : t.toCharArray()){
                if(!tMap.containsKey(c)){
                    tMap.put(c, 1);
                }else {
                    tMap.put(c, tMap.get(c) + 1);
                }
            }

            System.out.println("123");
            if(!sMap.keySet().equals(tMap.keySet())){
                return false;
            }

            for(char key : sMap.keySet()){
                if(!sMap.get(key).equals(tMap.get(key))){
                    return false;
                }
            }

            return true;
        }
    }

    class Solution2{
        public boolean isAnagram(String s, String t) {
            int[] sArray = new int[26];
            int[] tArray = new int[26];

            for(char c : s.toCharArray()){
                sArray[c - 'a'] = sArray[c - 'a'] + 1;
            }

            for(char c : t.toCharArray()){
                tArray[c - 'a'] = tArray[c - 'a'] + 1;
            }

            return Arrays.equals(tArray, sArray);
        }
    }
}
