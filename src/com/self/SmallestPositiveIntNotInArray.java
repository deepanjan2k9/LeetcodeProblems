package com.self;

import java.util.Arrays;

public class SmallestPositiveIntNotInArray {
    public static void main(String[] args){

    }

    public int solution(int[] A){
        int smallestMissingInteger = 0;
        int sizeOfA = A.length;
        int smallestDifference;
        //first sort the array in ascending order
        Arrays.sort(A);
        int candidateOperandOne = A[0];
        int candidateOperandTwo = A[0];

        //case when there is only one element in the array
        if(sizeOfA == 1){
            if(A[0] >= 0){
                smallestMissingInteger = A[0] + 1;
            }
            else {
                smallestMissingInteger = 1;
            }
        }

        //case when there are at least two elements in the array
        if(sizeOfA >= 2){
            smallestDifference = A[1] - A[0];
            for(int i=1; i<sizeOfA; i++){
                 
                int difference = Math.abs(A[i] - A[i-1]);
                if(smallestDifference > difference){
                    smallestDifference = difference;
                    candidateOperandOne = A[i-1];
                    candidateOperandTwo = A[i];
                    smallestMissingInteger = Math.min(candidateOperandOne + 1, candidateOperandTwo - 1);
                }
            }
        }
        
        

        return smallestMissingInteger;
    }
}
