package com.self;

import java.util.ArrayList;
import java.util.List;

public class UniqueSumToN {
    public static void main(String[] args){
        int N = 4;
        int[] arr = solution(N);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }   

    public static int[] solution(int N){
        List<Integer> uniqueSumN = new ArrayList<Integer>();
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum +=i;
            
        }
        uniqueSumN.remove(uniqueSumN.size()-1);
        int[] ans = new int[uniqueSumN.size()];
        for(int i=0; i<uniqueSumN.size(); i++){
            ans[i] = uniqueSumN.get(i);
        }
        return ans;
    }
}
