package com.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = spiralOrder(matrix);

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top=0,bot=matrix.length-1;
        int r=matrix[0].length-1,l=0;
        List<Integer> res=new ArrayList<>();
        while(top<=bot){
            for(int i=l;i<=r;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top>bot){
                break;
            }
            for(int i=top;i<=bot;i++){
                res.add(matrix[i][r]);
            }
            r--;
            if(l>r){
                break;
            }
            for(int i=r;i>=l;i--){
                res.add(matrix[bot][i]);
            }
            bot--;
            if(top>bot){
                break;
            }
            for(int i=bot;i>=top;i--){
                res.add(matrix[i][l]);
            }
            l++;
            if(l>r){
                break;
            }
        }
        return res;
    }
}