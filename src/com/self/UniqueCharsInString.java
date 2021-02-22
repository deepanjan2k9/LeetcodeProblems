/**
 * Implement an algorithm to determine whether a string has all unique characters without using an additional data structure(s).
 */

package com.self;

public class UniqueCharsInString {
    
    public static void main(String[] args){
        String s = "iamunique";
        System.out.println("Is unique s = " + s + " :" + isUnique(s));
    }

    public static boolean isUnique(String s){
        boolean unique = true;

        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    unique = false; 
                    break;
                }
            }
        }
        
        return unique;
    }
}
