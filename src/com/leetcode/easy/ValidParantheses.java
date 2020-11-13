/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' , ']'
 * Determine if the input string is valid.
 * An input string is valid only if:
 *  1. Open brackets must be closed by the same type of brackets.
 *  2. Open brackets must be closed in the correct order.
 * 
 * Constraints:
 *  1. 1 <= s.length <= 10^4
 *  2. s consists of parantheses only
 * 
 * Examples:
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * Input: "()"
 * Output: true
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * Input: "(]"
 * Output: false
 * 
 * Input: "([)]"
 * Output: false
 * 
 * @author Deepanjan Das
 * 
 * Use recursion.
 * 
*/

package com.leetcode.easy;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class ValidParantheses {
    
    public boolean isValid(String inputString){
         //check constraints - 
         //length of inputString
         if(inputString.length()<1 || inputString.length()>10000){
             return false;
         }
         //inputString must consist only of parantheses
         CharacterIterator iterator = new StringCharacterIterator(inputString); //can also use traditional for-loop
         while(iterator.current() != CharacterIterator.DONE){
            char c = iterator.current();
            if( c != '[' ||
                c != ']' ||
                c != '(' ||
                c != ')' ||
                c != '{' ||
                c != '}' ){
                    return false;
                }
         }

         char[] openParantheses = {'(', '{', '['};
         char[] closedParantheses = {')', '}', ']'};

         //char testChar = '';
         for(int i=0; i<inputString.length(); i++){
             if(inputString.charAt(i) == openParantheses[0] || 
                inputString.charAt(i) == openParantheses[1] ||
                inputString.charAt(i) == openParantheses[2]){
                    
                    continue;
                }

             if(i == 0 && inputString.charAt(i) == closedParantheses[0] || 
                          inputString.charAt(i) == closedParantheses[1] ||
                          inputString.charAt(i) == closedParantheses[2]){
                              return false;
                          }
              if(i > 0 && inputString.charAt(i) == closedParantheses[0] || 
                          inputString.charAt(i) == closedParantheses[1] ||
                          inputString.charAt(i) == closedParantheses[2]){
                              switch(inputString.charAt(i)){
                                  case ')': if(inputString.charAt(i-1) == '(') continue;
                                  case '}': if(inputString.charAt(i-1) == '}') continue;
                                  case ']': if(inputString.charAt(i-1) == ']') continue;
                                  default: return false;
                              }
                          }  
         }
        
        
        
        return false;
    }
}
