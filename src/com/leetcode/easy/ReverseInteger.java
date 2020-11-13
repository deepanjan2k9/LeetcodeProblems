package com.leetcode.easy;

public class ReverseInteger {
    public int reverse (int x){


        int negativeFlag = 1;
        if(x < 0){
            negativeFlag = -1;
        }
        int newX = x * negativeFlag;

        /*
        if((x > 2147483647)||(x < -2147483648)){
            return 0;
        }
        */
    


        //convert input integer into String representation
        String stringX = Integer.toString(newX);
        //convert String rep to an int array
        int[] xArray = new int[stringX.length()];
        for (int i=0; i<stringX.length();i++){
            xArray[i] = stringX.charAt(i) - '0';

        }
       
        //DEBUG 
        /*
        System.out.println("DEBUG: int array xArray: " );
        for(int i:xArray){
            System.out.print(" " + i);
        }
        */



        //create a temp int array that will hold the reversed integers
        int[] tempArray = new int[xArray.length];

        for(int i=xArray.length-1, j=0; i>=0; i--, j++){
            tempArray[j] = xArray[i];
        }

        //convert tempArray into actual int
        int result = 0;
        final int BASE = 10;


        for(int i=0; i<tempArray.length; i++){
            int power = tempArray.length-1 - i;
            result =  result + ((int)(Math.pow(BASE,power)) * tempArray[i]);
        }

        if((result < Integer.MIN_VALUE) || (result > Integer.MAX_VALUE)){
            return 0;
        } else {
            return result * negativeFlag;
        }
        
    }

    public static void main(String[] args){
        
        int x = 1534236469; //test input that breaks solution

        ReverseInteger obj = new ReverseInteger();
        int reverseX = obj.reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + reverseX);
    }
}
