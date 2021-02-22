/**
 * Write a function that takes a list of nuymbers and returns the largest one, if list is empty thenr eturn 0
 * 
 */

package com.self;
import java.util.Arrays;

public class LargestNumInList {
    public static long solution(long[] numbers) {
        // Type your solution here
        //check to see if list is empty, if so, then return 0
        long max = 0;
        if(numbers == null){
            return 0;
        }else {
        
            //sort the array
            Arrays.sort(numbers);
            int length = numbers.length;
            max = numbers[length - 1];
            
        }
        
        return max;
        
        
    }
}

