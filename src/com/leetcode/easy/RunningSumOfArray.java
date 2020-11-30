package com.leetcode.easy;

public class RunningSumOfArray {
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] ans = runningSum(nums);
        System.out.print("Input:");
        display(nums);
        System.out.print("Output:");
        display(ans);
    }

    public static void display(int[] nums){
        for(int i:nums){
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static int[] runningSum(int[] nums){
        final int LENGTH = nums.length;
        int[] result = new int[LENGTH];
        
        for(int i=0; i<LENGTH; i++){
            int tempSum = 0;
            if(i==0){
                tempSum = nums[i];
            }else{
                tempSum = nums[i] + result[i-1];
            }
            result[i] = tempSum;
        }
        
        return result;
    }
}
