/**
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array a of n integers and a number, d, perform d left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description

Complete the function rotLeft in the editor below.

rotLeft has the following parameter(s):

int a[n]: the array to rotate
int d: the number of rotations
Returns

int a'[n]: the rotated array
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations.
The second line contains  space-separated integers, each an .

Constraints
1<=n<=10^5
1<=d<=n
1<=a[i]<=10^6

Sample Input

n=5, d=4
a = [1 2 3 4 5]
Sample Output

5 1 2 3 4
Explanation
[1,2,3,4,5] --1--> [2,3,4,5,1] --2--> [3,4,5,1,2] --3--> [4,5,1,2,3] --4--> [5,1,2,3,4]
When we perform  left rotations, the array undergoes the following sequence of changes:


 */


package com.hackerrank;

public class ArrayLeftRotation {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int d=2;
        //int[] b = ArrayLeftRotation.leftRotation(a, d);
        int[] c = ArrayLeftRotation.leftRotation2(a, d);
        System.out.println("Left rotation " + d + " times: ");
        /*
        for(int i=0; i<b.length; i++){
            System.out.print(b[i] + " ");
        }*/
        System.out.println();
        for(int i=0; i<c.length; i++){
            System.out.print(c[i] + " ");
        }

    }

    //running time complexity worst case = O(n^2)
    //average case = O(d*n), best case = O(n)
    //space complexity= O(n)
    public static int[] leftRotation(int[] a, int d){
        int temp0=0;//to store the value of first element which is then appended to the end of array at the end of each while loop
        int i=0;
        while(i<d){
            for(int j=0; j<a.length-1; j++){
                if(j==0){
                    temp0 = a[j];
                }
                a[j] = a[j+1];
            }
            
            i++;
            a[a.length-1] = temp0;
        }
        
        return a;
    }
    
    //worst case running time = O(n)
    //space complexity = 2n
    public static int[] leftRotation2(int[] a, int d){
        int n=a.length;
        int[] temp = new int[n];
        for (int i=0; i<n; i++){  // ---O(n)
            int tempIndex = (i + (n - d))%n;
            temp[tempIndex] = a[i];
        }
        return temp;
    }
    
}
