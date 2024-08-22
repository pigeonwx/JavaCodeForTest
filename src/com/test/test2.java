package com.test;

import java.util.HashMap;
import java.util.Map;

public class test2 {
    //s 不含重复的最长字串长度
    //  s[1...len-1]  dp[i] dp[i+1]   i-dp[i]+1....i+1;
    public static void main(String[] args) {

        String s="12232345123";
        Map<Character,Integer> mp=new HashMap<>();
        int len=s.length();
        int ans=0;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(i==len-1){
                if(mp.containsKey(c)){
                    int index=mp.get(c);
                    int t=i-index;
                    ans=Math.max(ans,t);
                    mp.put(c,i);
                }else{

                }
            }
            if(mp.containsKey(c)){
                 int index=mp.get(c);
                 int t=i-index;
                 ans=Math.max(ans,t);
                 mp.put(c,i);
            }else{
                mp.put(c,i);
            }
            ans=Math.max(ans,mp.size());
        }
        System.out.println(ans);

    }
}
