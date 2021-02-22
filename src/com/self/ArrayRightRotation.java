package com.self;

public class ArrayRightRotation {
    public static void main(String[] args){
        int[] A = {3,8,9,7,6};
        int K = 7;

        System.out.println("Array right-rotated " + K + " times: ");
        int[] newA = solution(A, K);
        for(int i=0; i<newA.length; i++){
            System.out.print(newA[i] + " ");
        }
    }

    //Run time complexity = O(n), where n is size of the input array
    public static int[] solution(int[] A, int K){
        
        int n = A.length;
        if(K == n){
            return A;
        }
        if(K > n){
            K = K-n;
        }
        int[] temp = new int[n];

        for(int i=0; i<n; i++){
            int rotatedIndex = (i + (n-K))%n;
            temp[i] = A[rotatedIndex];
        }

        return temp;
    }
    
}
