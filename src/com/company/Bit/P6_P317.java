package com.company.Bit;

/**
 * 不用额外变量交换两个整数
 * 《程序员代码面试指南》 P317
 */
public class P6_P317 {

     public static void main(String[] args){
         int a = 1, b = 2;
         a = a ^ b;
         b = a ^ b;
         a  = a ^ b;

     }


}
