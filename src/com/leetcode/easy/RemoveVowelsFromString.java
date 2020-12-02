package com.leetcode.easy;

public class RemoveVowelsFromString {
    public static void main(String[] args){
        String s = "leetcodeisacommunityforcoders";
        String s2 = "aeiou";
        String s3 = "leet";
        RemoveVowelsFromString obj = new RemoveVowelsFromString();
        
        System.out.println("Input: " + s);
        System.out.println("Result: " + obj.removeVowels(s));
        System.out.println("Input: " + s2);
        System.out.println("Result: " + obj.removeVowels(s2));
        System.out.println("Input: " + s3);
        System.out.println("Result: " + obj.removeVowels(s3));

    }   

    public String removeVowels(String s){
        final int LENGTH = s.length();
        String result = ""; 
        char[] charArray = new char[LENGTH];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
        
        for(int i=0,j=0; i<LENGTH; i++){

            if(s.charAt(i) == 'a' ||
               s.charAt(i) == 'e' ||
               s.charAt(i) == 'i' ||
               s.charAt(i) == 'o' ||
               s.charAt(i) == 'u'){
                   continue;
               }else {
                   charArray[j] = s.charAt(i);
                   j++;
               }
        }
       
        result = String.valueOf(charArray).trim();

        return result;
    }
}
