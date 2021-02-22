/**
 * Given an array "nums" consisting of 2n elements of the form [x1, x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn]
 * 
 * Constraints:
 * 1<=n<=500
 * nums.length == 2n
 * 1<=nums[i]<=10^3
 * 
 * Example 1:
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7] 
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 * 
 * Example 3: 
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 * 
 */

package com.leetcode.easy;

public class ShuffleArray {

    public static void main(String[] args){
        //int[] nums = {2,5,1,3,4,7}; 
        //int n = 3;
        //int[] nums = {1,2,3,4,4,3,2,1};
        //int n = 4;
        int[] nums = {1,1,2,2};
        int n = 2;

        System.out.println("Input: ");
        for (int i:nums){
            System.out.print(i + " ");

        }

        System.out.println();
        int[] shuffledNums = shuffle(nums, n);

        System.out.println("Output: ");        
        for(int i:shuffledNums){
            System.out.print(i + " ");
        }

    }

    public static int[] shuffle(int[] nums, int n){
        
        int[] temp = new int[nums.length];
        
        //i -> number of times the loop should run
        //j -> index of xn in nums
        //k -> index of yn in nums
        //l -> index of temp array that is being returned
        
        for(int i=0,j=0,l=0; i<n; i++,j++,l++){
            
            temp[l] = nums[j];
            temp[l+1] = nums[j+n];
            //l has to be incremented twice
            l = l+1;
        }
        return temp;
    } 

}
