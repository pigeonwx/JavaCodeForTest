package com.test.lxhy;

public class test_lxhy_0817_2 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 3, 2, 3, 3};
//        System.out.println(splitArray(arr));
        System.out.printf("{ ");
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            System.out.printf("{ ");
            for (int j = i + 1; j < Integer.MAX_VALUE; j++) {
                if (isOK(i, j)) {
                    System.out.printf(" %d,", 1);
                }
            }
            System.out.printf(" },");
        }
        System.out.printf(" }");
    }

    public static int splitArray(int[] nums) {
        // write code here
        int len = nums.length;
        int cnt = 0;
        int i = 0;
        int j = len - 1;
        for (; i < len; ) {
            for (j = len - 1; j >= i; j--) {
                if (isOK(nums[i], nums[j])) {
                    cnt++;
                    i = j + 1;
                    break;
                }
            }
            if (j == i) {
                i++;
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isOK(int x, int y) {
        if (x > y) {
            return isOK(y, x);
        }

        int t = y % x;
        while (t != 0) {
            y = x;
            x = t;
            t = y % x;
        }
        return x > 1;
    }
}
