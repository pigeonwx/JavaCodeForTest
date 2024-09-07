package com.test.qne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test_0906_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        int[] arr = new int[n];
        List<Integer> l11 = new ArrayList<>();
        List<Integer> l22 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            l11.add(arr[i]);
        }
        int[] car = new int[n];
        for (int i = 0; i < n; i++) {
            car[i] = in.nextInt();
            l22.add(car[i]);
        }
        Collections.sort(l11);
        Collections.sort(l22);
        long st=0;
        for (int i = 0; i < n; i++) {
            st=(long) l11.get(i) *l22.get(i);
            if(st>m){
                break;
            }
        }
        if(st<m){
            System.out.println(-1);
            return;
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        boolean flag = false;
        int res=0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            l1.add(arr[i]);
            l2.add(car[i]);
            Collections.sort(l1);
            Collections.sort(l2);
            sum = 0;
            res++;
            for (int j = i; j >= 0; j--) {
                sum += (long) l1.get(j) * l2.get(j);
                if (sum >= m) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        if (flag) {
            System.out.println(res);
        }else{
            System.out.println(-1);
        }
    }
}
