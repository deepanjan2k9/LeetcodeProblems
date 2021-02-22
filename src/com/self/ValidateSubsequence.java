package com.self;

/**
 * 
 * Given two non-empty array of integers, write a function that determines whether the second array is a subsequence of the first
 * one.
 * A subsequence of an array is a set of numbers that are not necessarily adjacent in the array but that are in the same order as
 * they appear in the array. 
 * 
 * Example - 
 * array: [5, 1, 22, 25, 6, -1, 8, 10]
 * sequence: [1, 6, -1, 10]
 */

import java.util.*;

public class ValidateSubsequence{
    public static void main(String[] args){
        List<Integer> array = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        /* result should be true
        array.add(5);
        array.add(1);
        array.add(22);
        array.add(25);
        array.add(6);
        array.add(-1);
        array.add(8);
        array.add(10);

        sequence.add(1);
        sequence.add(22);
        sequence.add(6);
        sequence.add(10);
        */

        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);

        sequence.add(1);
        sequence.add(1);
        sequence.add(1);
        

        boolean answer = isValidSubsequence(array, sequence);
        System.out.print(answer);
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        //at every iteration where we check whether an element in sequence is also present in array,
        //we refer to a variable called startIndexInArray.
        //This is the index of the element in array that is also present in sequence, and which was found in the 
        //previous iteration.
        //Initially startIndexInArray is -1.
        int startIndexInArray = -1;
        
        //hashmap will have key, value pair like so -
        //key = element in array
        //value = index of that element in array
        //if there is an element which repeats in the array, it will have multiple indexes,
        //thereby maintaining the constraint of a hashmap
        //HashMap<Integer, Integer> mapElementToIndexInArray = new HashMap<>();
        Map<Integer, List<Integer>> mapElementToIndexInArray = new HashMap<>();

        List<Integer> multipleIndexes = new ArrayList<>();
        int prevValueInArray = array.get(0);
        //int tempValue;
        //populate the hashmap
        for(int i=0; i<array.size(); i++){
            if(i==0){
                multipleIndexes.add(i);
                prevValueInArray = array.get(i);
            }
            if(i>0 && array.get(i) == prevValueInArray){
                multipleIndexes.add(i);
                //prevValueInArray = array.get(i);
            }
            if(i>0 && array.get(i) != prevValueInArray){
                mapElementToIndexInArray.put(prevValueInArray, multipleIndexes);
                multipleIndexes.clear();
                multipleIndexes.add(i);
                prevValueInArray = array.get(i);
            }
            //current index is the last index so we only need to do is add the key-val pair regardless
            //of the value of prevValueInArray
            if(i == array.size() - 1){
                mapElementToIndexInArray.put(prevValueInArray, multipleIndexes);
            }
            
        }

        List<Integer> indexes = new ArrayList<>();
        /*Need to modify this part */
        for(int i=0; i<sequence.size(); i++){
            //tempIndex is a temp variable that tracks the index (in the array) of the current element in sequence found in 
            //the array.
            //This enables us to compare whether the index of this current element in array is more than that of the index
            //of the previously found element - to check the order constraint of this problem
            int tempIndex = startIndexInArray;

            try{
                if(mapElementToIndexInArray.containsKey(sequence.get(i))){

                    //tempIndex = mapElementToIndexInArray.get(sequence.get(i));
                    //below line of code is the wrong way to assign indexes
                    //indexes = mapElementToIndexInArray.getValue(sequence.get(i));
                    indexes = mapElementToIndexInArray.get(key)
                    

                    tempIndex = indexes.get(indexes.size() - 1);
                    if(tempIndex > startIndexInArray)
                    {
                        startIndexInArray = tempIndex;
                    }
                    else{//not in same order, therefore return false
                        return false;
                    }
                    
                }
                else{//current element in sequence not found in array, so return false
                    return false;
                }

                indexes.clear(); //clear indexes for the next iteration

            }catch(IndexOutOfBoundsException e){
                System.out.println("IndexOutOfBoundsException encountered at sequence for-loop");
                System.out.println("Printing variables...");
                System.out.println("i = " + i + ", tempIndex = " + tempIndex + ", startIndexInArray = " + startIndexInArray);
                System.out.println("indexes = ");
                for(int index=0; index<indexes.size(); index++){
                    System.out.print(indexes.get(index) + " ");
                }
            }

            
        }
        
        return true;
    }
}
