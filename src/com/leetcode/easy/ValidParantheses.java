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
*/

package com.leetcode.easy;
import java.util.*;

public class ValidParantheses {

    public static void main(String[] args){
        String input1 = "(((((())))))";
        String input2 = "()()()";
        String input3 = "(((((())";
        String input4 = "((()(())))";
        String input5 = "()[]{}";
        String input6 = "([)]"; 
        String input7 = "(abcd)";
        String input8 = "({(()()())})";
        String input9 = "[()]";
        String input10 = "{[]";

        System.out.println("Validity for input: " + input1 + " is: " + isValid(input1));
        System.out.println("Validity for input: " + input2 + " is: " + isValid(input2));
        System.out.println("Validity for input: " + input3 + " is: " + isValid(input3));
        System.out.println("Validity for input: " + input4 + " is: " + isValid(input4));
        System.out.println("Validity for input: " + input5 + " is: " + isValid(input5));
        System.out.println("Validity for input: " + input6 + " is: " + isValid(input6));
        System.out.println("Validity for input: " + input7 + " is: " + isValid(input7));
        System.out.println("Validity for input: " + input8 + " is: " + isValid(input8));
        System.out.println("Validity for input: " + input9 + " is: " + isValid(input9));
        System.out.println("Validity for input: " + input10 + " is: " + isValid(input10));
        System.out.println("END");
    }
    
    public static boolean isValid(String inputString){
         //check constraints - 
         //length of inputString
         if(inputString.length()<1 || inputString.length()>10000){
             return false;
         }
         //inputString must consist only of parantheses
         //boolean invalidChars = true;
         //ArrayList contains of only the possible parantheses
         ArrayList<String> dictionary = new ArrayList<>();
         dictionary.add("(");
         dictionary.add(")");
         dictionary.add("{");
         dictionary.add("}");
         dictionary.add("[");
         dictionary.add("]");
         //compare each character of inputString with the ArrayList to see if 
         //it contains only parantheses or not. This comparison takes O(n^2) time
         //because the for-loop takes O(n) and the ArrayList.contains() takes O(n)
         for(int i=0; i<inputString.length(); i++){
            char bracket = inputString.charAt(i); 
             if(dictionary.contains(String.valueOf(bracket))){ 
                continue;
            }else {
                return false;
            }
         } 
         
         //another constraint is that the length of inputString needs to be even, and greater than equal to 2
        if(inputString.length() %2 != 0){
            return false;
        }

        //simple case when there is only one kind of paratheses, say '()'
        //the number of each parantheses '(' and ')' must be even
        //so set up a counter for each
        int openCounter = 0;
        int openCurlyCounter = 0;
        int openSquareCounter = 0;
        
        //This stack stores the type of open paratheses last encountered. When
        //a closed parantheses is encountered, the program checks the stack for
        //the last encountered open paratheses to see if there is a match.
        Stack encounterType = new Stack();


        for(int i=0; i<inputString.length(); i++){

            if(inputString.charAt(i) == '('){
                openCounter++;
                encounterType.push("normal");
            }
            if(inputString.charAt(i) == ')'){
                try{
                    if(openCounter > 0 && encounterType.pop().toString().equals("normal")){
                        openCounter--;
                    } 
                }catch(EmptyStackException ese){
                    System.out.println("Error: " + ese.getMessage());
                    return false;
                }
            }
            
            if(inputString.charAt(i) == '{'){
                openCurlyCounter++;
                encounterType.push("curly");
            }
            if(inputString.charAt(i) == '}'){
                try{
                    if(openCurlyCounter > 0 && encounterType.pop().toString().equals("curly")){
                        openCurlyCounter--;
                    }
                }catch(EmptyStackException ese){
                    System.out.println("Error: " + ese.getMessage());
                    return false;
                }
            }

            
            if(inputString.charAt(i) == '['){
                openSquareCounter++;
                encounterType.push("square");
            }
            if(inputString.charAt(i) == ']'){
                try{
                    if(openSquareCounter > 0 && encounterType.pop().toString().equals("square")){
                    openSquareCounter--;
                }
                }catch(EmptyStackException ese){
                    System.out.println("Error: " + ese.getMessage());
                    return false;
                }
            }
        }

        //check if openCounter == closeCounter
        if(openCounter == 0 && openCurlyCounter == 0 && openSquareCounter == 0){
            return true;
        } else return false;
    }
}
