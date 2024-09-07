package com.test.xhs;

import java.util.Scanner;

public class test_0901_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int[] arr = new int[n + 2];
        int[] leftCnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            if (arr[i] > arr[i - 1]) {
                leftCnt[i] = leftCnt[i - 1] + 1;
            } else {
                leftCnt[i] = 1;
            }
        }
        int maxL=leftCnt[n];
        int cnt=0;
        for(int i=n;i>=1;i--){
            if(arr[i]>arr[i+1]){
                cnt++;
            }else{
                cnt=1;
            }
            if(leftCnt[i]+cnt-1>maxL){
                maxL=leftCnt[i]+cnt-1;
            }
        }
        System.out.println(maxL);
    }
}
