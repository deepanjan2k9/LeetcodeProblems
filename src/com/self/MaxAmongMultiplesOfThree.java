package com.self;

import java.util.ArrayList;
import java.util.List;

public class MaxAmongMultiplesOfThree {
    
    public static void main(String[] args){
        int[] A = {-6, -91, 1011, -100, 84, -22, 0, 1, 473};
        int ans = solution(A);
        System.out.print(ans);
        
    }

    public static int solution(int[] A){
        List<Integer> candidates = new ArrayList<Integer>();

        for(int i=0; i<A.length; i++){
            if(A[i]!=0 && A[i]%3 == 0){
                candidates.add(A[i]);
            }
        }

        //find out the max within the ArrayList
        int max = -10001; //initially max is set below negative range of input
        for(int i=0; i<candidates.size(); i++){
            if(max < candidates.get(i)){
                max = candidates.get(i);
            }
        }

        return max;
    }
}
