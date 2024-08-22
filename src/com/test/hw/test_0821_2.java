package com.test.hw;

import java.util.*;

public class test_0821_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] tasks = new int[2];
        int[] taskArray = new int[n];
        int[] machines = new int[3];
        for (int i = 0; i < n; i++) {
            int t = s.nextInt();
            taskArray[i] = t;
            tasks[t] += 1;
        }
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            machines[m] += 1;
        }
        int flag = -1;
        for (int i = 0; i < n; i++) {
            int t = taskArray[i];
            if (flag == -1) {
                // 2 or t
                if (machines[t] == 0) {
                    flag = t;
                    machines[2]--;
                    tasks[t]--;
                } else {
                    if(tasks[t]>tasks[1-t]){
                        flag = t;
                        machines[2]--;
                        tasks[t]--;
                    }
                }
            } else {
                if (machines[t] > 0) {
                    machines[t]--;
                    tasks[t]--;
                } else if (machines[2] > 0) {
                    machines[2]--;
                    tasks[t]--;
                } else {
                    break;
                }
            }
        }
        System.out.println(machines[0] + machines[1] + machines[2]);
    }
}
