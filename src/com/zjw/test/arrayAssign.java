package com.zjw.base;

public class arrayAssign {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3};
        int[] b = new int[4];
        b = a;
        for(int i = 0; i < 4; i++){
            a[i] = 0;
            System.out.println(a[i] + b[i]);
        }
    }
}
