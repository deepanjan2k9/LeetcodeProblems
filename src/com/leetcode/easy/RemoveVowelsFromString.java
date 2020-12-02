package com.leetcode.easy;

public class RemoveVowelsFromString {
    public static void main(String[] args){
        /*String s = "leetcodeisacommunityforcoders";
        String s2 = "aeiou";*/
        String s3 = "leet";
        RemoveVowelsFromString obj = new RemoveVowelsFromString();
        /*
        System.out.println("Input: " + s);
        System.out.println("Result: " + obj.removeVowels(s));
        System.out.println("Input: " + s2);
        System.out.println("Result: " + obj.removeVowels(s2));*/
        System.out.println("Input: " + s3);
        System.out.println("Result: " + obj.removeVowels(s3));

    }   

    public String removeVowels(String s){
        String result = "";                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        StringBuilder strBuilder = new StringBuilder(s);
        for(int i=0; i<strBuilder.length(); i++){
            if(strBuilder.charAt(i) == 'a' ||
               strBuilder.charAt(i) == 'e' ||
               strBuilder.charAt(i) == 'i' ||
               strBuilder.charAt(i) == 'o' ||
               strBuilder.charAt(i) == 'u'){
                   strBuilder.deleteCharAt(i);
               }
               System.out.println("StringBuilder at iteration: " + i + " after removal: " + strBuilder.toString());
        }
        result = strBuilder.toString();

        return result;
    }
}
