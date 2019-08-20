package com.zjw.algorithm;

import java.util.Scanner;

/*
    华为笔试第二题，树
 */
public class POUNDS {

    public static int getResult(int m, int n, int p, int[] labels, int[] hasChild, int[] pouds, int[] values, int[] key){
        int[] pos = new int[m];
        int indexOfVal = 0;
        for(int i = 0; i < m; i++){
            if(hasChild[i] == 0){
                pos[i] = values[indexOfVal++];
            }
        }
        int indexOfLab = m - 1;
        for(int i = 0; i < p - 1; i++){
            while(labels[indexOfLab] != key[i]){
                indexOfLab--;
                if(indexOfLab < 0) return 0;
            }
            while(hasChild[indexOfLab] == 0){
                while(labels[indexOfLab] != key[i]){
                    indexOfLab--;
                    if(indexOfLab < 0) return 0;
                }
            }
            indexOfLab--;
            if(indexOfLab < 0) return 0;
        }
        for(;; indexOfLab--){
            if(indexOfLab < 0) return 0;
            if(labels[indexOfLab] == key[p - 1] && hasChild[indexOfLab] == 0){
                break;
            }
        }
        return pos[indexOfLab];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] labels = new int[m];
        int[] hasChild = new int[m];
        int[] pouds = new int[m];
        for(int i = 0; i < m; i++){
            labels[i] = in.nextInt();
        }
        for(int i = 0; i < m; i++){
            hasChild[i] = in.nextInt();
        }
        for(int i = 0; i < m; i++){
            pouds[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] values = new int[n];
        for(int i = 0; i < n; i++){
            values[i] = in.nextInt();
        }
        int p = in.nextInt();
        int[] key = new int[p];
        for(int i = 0; i < p; i++){
            key[i] = in.nextInt();
        }
        System.out.println(getResult(m, n, p, labels, hasChild, pouds, values, key));
    }
}
