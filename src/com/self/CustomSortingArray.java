package com.self;

import java.util.ArrayList;
import java.util.List;

public class CustomSortingArray {
 
    public static void main(String[] args){
        List<Integer> integerArray = new ArrayList<>();
        integerArray.add(8);
        integerArray.add(5);
        integerArray.add(11);
        integerArray.add(4);
        integerArray.add(6);
        int minimumMoves = moves(integerArray);
        System.out.println("Moves: " + minimumMoves);
    }

    public static int moves(List<Integer> arr){
        if(arr.size() < 2){
            return 0;
        }
        int minimumMoves = 0;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i)%2==0){
                continue;
            }
            else{
                
                for(int j=i+1; j<arr.size(); j++){
                    if(arr.get(j)%2==0){
                        //need to swap so incrment minimumMoves
                        minimumMoves++;
                        //after the move, the array is modified, the current i index has
                        //an even int after the move, so go to the next int
                        break;
                    }
                }
            }
        }
        

        return minimumMoves;
    }
}
