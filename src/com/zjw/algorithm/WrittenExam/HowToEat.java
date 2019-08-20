package com.zjw.algorithm;

import java.util.Scanner;

/*
    选自大疆笔试题 应该怎么吃呢
 */
public class HowToEat {

    private static int getNumber(int v, int n, int[] price, int m, int[] fav){
        int res = 0, tmp = v;
        for(int i = m - 1; i >= 0; i--){
            tmp -= (price[fav[i]] * (m - i));
        }
        if(tmp == 0) return 1;
        return res;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int v = in.nextInt(), n = in.nextInt();
        int[] price = new int[n + 1];
        for(int i = 1; i <= n; i++){
            price[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] fav = new int[m];
        for(int i = 0; i < m; i++){
            fav[i] = in.nextInt();
        }
        in.close();

        int res = getNumber(v, n, price, m, fav);

        System.out.println(res);
    }
}
