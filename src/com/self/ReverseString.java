package com.self;

public class ReverseString {
    public static void main(String[] args){
        String input = "deepanjan";

        System.out.println("Reverse of " + input + " is: " + solution(input));
    }

    public static String solution(String input){
            byte[] inputAsByteArray = input.getBytes();
            byte[] result = new byte[inputAsByteArray.length];

            for(int i=0; i<inputAsByteArray.length; i++){
                result[i] = inputAsByteArray[inputAsByteArray.length - i - 1];
            }

            return new String(result);

    }
}
