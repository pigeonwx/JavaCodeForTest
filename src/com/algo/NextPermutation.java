package com.algo;
import java.util.*;
class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int last=nums.length-2;
        for(;last>=0;last--){
            if(nums[last]>nums[last+1]){
                break;
            }
        }
        int min_max=0x7fffffff;
        int index=last+1;
        for(int i=last+1;i<nums.length-1;i++){
            if(nums[i]>nums[last]&&nums[i]<=min_max){
                min_max=nums[i];
                index=i;
            }
        }
        nums[index]=nums[last];
        nums[last]=min_max;
        Arrays.sort(nums, last + 1, nums.length);
        return;
    }

    public static void main(String[] args) {
        int []nums= new int[]{1,2,3};
        nextPermutation(nums);

    }
}