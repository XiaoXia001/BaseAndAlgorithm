package com.zjw.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    public static int calculate(String s) {
        Stack data = new Stack();  //数据栈
        Stack<Character> symbol = new Stack(); //符号栈
        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            if(s.charAt(i) == '0' || s.charAt(i) == '1'){
                data.push(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
            else if (s.charAt(i) == '&' || s.charAt(i) == '|' || s.charAt(i) == '!') {
                if(s.charAt(i) == '!'){
                    i++;

                }else{
                    symbol.push(s.charAt(i));
                }
            }
            else if(s.charAt(i)=='(') data.push("(");
            else if(s.charAt(i)==')') {
                StringBuilder stringBuilder =new StringBuilder();
                while(true){
                    String tmp = String.valueOf(data.pop());
                    if(tmp.equals("(")) break;
                    stringBuilder.insert(0,tmp);
                    if(!symbol.empty())
                        stringBuilder.insert(0,symbol.pop());
                }
                if(stringBuilder.toString().charAt(0)=='&' || stringBuilder.toString().charAt(0)=='|' || stringBuilder.toString().charAt(0)=='!') {
                    symbol.push(stringBuilder.toString().charAt(0));
                    stringBuilder.delete(0, 1);
                }
                int res_tmp=calculate(stringBuilder.toString());//递归计算括号内结果
                data.push(res_tmp);
            }
        }
        int res = 0;
        while (data.size() != 1) {
            int num=0;
            switch ((char) symbol.pop()) {
                case '&':
                    res &= (int)data.pop();
                    break;
                case '|':
                    res |= (int)data.pop();
                    break;
                case '!':
                    if(res == 0){
                        res = 1;
                    }else{
                        res = 0;
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(calculate(s));

    }
}
