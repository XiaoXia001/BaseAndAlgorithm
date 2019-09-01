package com.zjw.base;

import java.util.Scanner;

public class TestScanner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            System.out.println(in.nextInt());
            in.nextLine();
        }
    }
}
