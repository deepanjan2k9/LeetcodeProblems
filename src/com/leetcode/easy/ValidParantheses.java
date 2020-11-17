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

         //another constraint is that the length of inputString needs to be even, and greater than equal to 2
        if(inputString.length() %2 != 0){
            return false;
        }

        //recursion
        //base case: encounter a pair, return

        //OR
        //if theres a valid pair, then a parantheses at position 'i' will have its other pair at the
        //symmetrically opposite position in the string, i.e. string.length() - (i+1)
        return false;
    }
}
