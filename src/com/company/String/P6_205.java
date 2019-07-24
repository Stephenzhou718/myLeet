package com.company.String;

/**
 * 字符串同构
 * 要求：
 * 难度：Easy
 * 第一次是否做出：否
 */
public class P6_205 {
    public static void main(String[] args){
        System.out.println(new P6_205().isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t){
        int[] aTob = new int[256];
        int[] bToa = new int[256];
        int size = s.length();

        for(int i = 0; i < size; i++){
            if(aTob[s.charAt(i)] == 0){
                aTob[s.charAt(i)] = t.charAt(i);
            }

            if(bToa[t.charAt(i)] == 0){
                bToa[t.charAt(i)] = s.charAt(i);

            }

            if(aTob[s.charAt(i)] != t.charAt(i) || bToa[t.charAt(i)] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

}
