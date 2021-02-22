package com.self;

import java.util.HashSet;
import java.util.Set;




public class RegexTest {
   

    public static void main(String[] args){
        String input1 = "ABCD";
        String input2 = "AABBCC";
        String input3 = "abcd";
        
        boolean test1 = testAZ(input1);
        boolean test2 = testAZ(input2);
        boolean test3 = testAZ(input3);

        System.out.println(input1 + " " + test1);
        System.out.println(input2 + " " + test2);
        System.out.println(input3 + " " + test3);
        
        
    }

    public static boolean testAZ(String inputString){
        
        
        Set<Character> set = new HashSet<>();
        for(char c:inputString.toCharArray()){
            if(!Character.isUpperCase(c)){
                return false;
            }
            if(set.contains(c)){
                return false;
            }
            set.add(c);
            
        }
        return true;
    }
}
