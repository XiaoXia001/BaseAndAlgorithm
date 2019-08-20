package com.zjw.algorithm;

import java.util.Scanner;

public class VerifyBST {

    public VerifyBST() {
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        int n = sequence.length;
        if(n <= 1) return true;
        return verify(sequence, 0, n - 1);
    }

    public boolean verify(int[] array, int s, int e){
        if(e - s <= 1) return true;
        int index = s;
        boolean flag = false;
        while(index < e){
            if(array[e] < array[index]){
                for(int i = index; i < e; i++){
                    if(array[i] < array[e]) return false;
                }
                break;
            }
            index++;
        }
        if(verify(array, s, index - 1)){
            flag = verify(array, index, e - 1);
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] sequence = new int[n];
        for(int i = 0; i < n; i++){
            sequence[i] = in.nextInt();
        }
        VerifyBST bst = new VerifyBST();
        System.out.println(bst.VerifySquenceOfBST(sequence) ? 1 : 0);
        return;
    }
}
