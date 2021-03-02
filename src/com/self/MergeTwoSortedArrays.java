/**Merge two sorted arrays, so that the resulting array should itself be sorted. */

package com.self;

public class MergeTwoSortedArrays {
    public static void main(String[] args){
        int[] arr1 = {1,3,4,5};
        int[] arr2 = {2,6,7,8};

        System.out.println("Printing result array: ");
        int[] result = mergeArrays(arr1, arr2);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2){

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int resultLength = arr1Length + arr2Length;
        int result[] = new int[resultLength];
        
        int i=0; //index pointer arr1
        int j=0; //index pointer arr2
        int k=0; //index pointer result

        try{
            while(i<arr1Length && j<arr2Length){
                if(arr1[i] < arr2[j]){
                  result[k] = arr1[i];
                  i++;
                  k++;
                  continue;
                }
                if(arr1[i] > arr2[j]){
                  result[k] = arr2[j];
                  j++;
                  k++;
                  continue;
                }
                if(arr1[i] == arr2[j]){
                  result[k] = arr1[i];
                  i++;
                  k++;
                  result[k] = arr2[j];
                  j++;
                  k++;
                  continue;
                }
            }

            //store the remaining elements of either arr1 or arr2
            //in the result array
            if(i==arr1Length && j<arr2Length){
                System.out.println("i finished, j not");
                while(j<arr2Length){
                  result[k] = arr2[j];
                  j++;
                  k++;
                }
              }

            if(j==arr2Length && i<arr1Length){
                System.out.println("i not, j finished");
                while(i<arr1Length){
                  result[k] = arr1[i];
                  i++;
                  k++;
                }
              }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Encountered ArrayIndexOutOfBoundsException. ");
            System.out.println("Value of i: " + i);
            System.out.println("Value of j: " + j);
            System.out.println("Value of k: " + k);
        }
        
        return result;

    }
}
