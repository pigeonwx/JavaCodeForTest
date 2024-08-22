package com.test;


import java.util.*;

public class test {
    
    public static void main(String[] args) {
        int []nums = new int[]{1,2,-2,-1};
        List<List<Integer>> res=threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            int t=nums[i];
            map.put(t,map.getOrDefault(t,0)+1);
        }
        for(int i=0;i<len-2;){
            int l=nums[i];
            int tgt=-l;
            // find nums[m]+nums[r]=tgt
            for(int j=i+1;j<len-1;){
                int m=nums[j];
                if(map.containsKey(tgt-m)&&tgt-m>=m){
                    if(tgt-m==m&&map.get(m)>1){
                        res.add(new ArrayList<>(List.of(l, m, tgt - m)));
                    }
                }
                if(l==m){
                    j=j+map.get(m)-1;
                }else{
                    j=j+map.get(m);
                }
            }
            // i到下一位
            i=i+map.get(l);
        }
        return res;
    }
}
