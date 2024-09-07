package test;

import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n==1){
                System.out.printf("%d ",0);
            }else if(n==2){
                System.out.printf("%d ",m);
            }else{
                System.out.printf("%d ",2*m);
            }
        }
    }

}
