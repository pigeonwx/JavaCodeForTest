package com.test;

import java.util.Scanner;

public class test_jd_0810_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.next();
        int x=0,y=0;
        int [][] dir={{0,1},{-1,0},{0,-1},{1,0}};
        int len=str.length();
        int d=0;
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            if(c=='D'){
                d=(d-1+4)%4;
            }else if(c=='A'){
                d=(d+1+4)%4;
            }else if(c=='S'){
                continue;
            }else{
                x+=dir[d][0];
                y+=dir[d][1];
            }
        }
        System.out.printf("%d %d",x,y);
    }
}
