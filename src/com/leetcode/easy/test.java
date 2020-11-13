package com.leetcode.easy;

public class test {

    public static void main(String[] args){
        int originput = -123;
        int input = 0;
        int negativeOrPositive =1;
        if(originput < 0 ){
            negativeOrPositive = -1;
            input = originput * negativeOrPositive;
        }
        String inputString = Integer.toString(input);

        int[] inputArray = new int[inputString.length()];
        for (int i=0; i<inputString.length();i++){
            inputArray[i] = inputString.charAt(i) - '0';
        }

        int[] tempArray = new int[inputArray.length];

        for(int i=inputArray.length-1, j=0; i>=0; i--, j++){
            tempArray[j] = inputArray[i];
        }

        //convert tempArray into actual int
        int result = 0;
        final int BASE = 10;


        for(int i=0; i<tempArray.length; i++){
            int power = tempArray.length-1 - i;
            result =  result + ((int)(Math.pow(BASE,power)) * tempArray[i]);
        }

        if(originput < 0){
            result = result * negativeOrPositive;
        }

        System.out.println("Input: " + originput + "\n Output: " + result);

    }
}
