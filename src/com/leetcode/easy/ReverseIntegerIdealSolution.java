package com.leetcode.easy;

public class ReverseIntegerIdealSolution {
    public static void main(String[] args){
        ReverseIntegerIdealSolution obj = new ReverseIntegerIdealSolution();
        //int x = 153423;
        int x = 1534236469; //input that breaks solution
        int ans = obj.reverse(x);
        System.out.println("Input: " + x);
        System.out.println("Output: " + ans);
    }

    public int reverse(int x){
        /**
         * Integer max value = 2^31 - 1
         * The last digit of 2^31 is 8, which is > 7. So when checking for overflow, for 
         * positive x, we only need to check the last digit of reversed at a particular loop
         * iteration, the last digit being lastDigit, whether it is > 7, given that the rest
         * of the reverse number's digits (reverse*10) where reverse here is the value from the
         * previous iteration, are same as those of the first till last but one digits of 2^31 -1.
         * Hence, for positive x, overflow is checked by 
         * reverse*10 == Integer.MAX_VALUE/10 && lastDigit > 7
         * Remember that being an int, Integer.MAX_VALUE/10 will only return first till last 
         * but one digits.
         * The last digit of 2^1 is 2, 2^2 is 4, 2^3 is 8, 2^4 is 6, 2^5 is 2 again and it repeats.
         * 
         * Similar logic for the case when x is negative.
         * Integer min value = -2^31
         * Last digit of -2^31 is 8, being negative we need to check lastDigit <-8 for overflow
         * given that the rest of the digits of the reverse are same as Integer.MIN_VALUE
        */
        
        
        int reversed = 0;
        int lastDigit = 0;

        while(x != 0){
            //find out last digit of x
            lastDigit = x % 10;
            //overflow can happen here, so need to check
            if(reversed > Integer.MAX_VALUE/10){
                //guaranteed overflow, so return 0
                return 0;
            }
            if((reversed == Integer.MAX_VALUE/10) && lastDigit > 7){
                //overflow only if lastDigit > 7
                    //guaranteed overflow, so return 0
                    return 0;
            }
            //Similary if x is negative
            if(reversed < Integer.MIN_VALUE/10) {
                return 0;
            }
            if((reversed == Integer.MIN_VALUE/10) && lastDigit < -8){
                return 0;
            }
            reversed = reversed*10 + lastDigit;  
            //remove the last digit from xCopy
            x = x/10;
        }

        return reversed;
        
    }


}
