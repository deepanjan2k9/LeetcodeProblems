package com.self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ThreeLargestNumbers {
    public static void main(String[] args) {
        int[] array = { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
        int[] threeLargestNumbers = findThreeLargestNumbers(array);
        System.out.println("Three max numbers: ");
        for (int i = 0; i < threeLargestNumbers.length; i++) {
            System.out.print(threeLargestNumbers[i] + " ");
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {

        // Stack<Integer> maxStack = new Stack<>();
        // key = index, value = value at index
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int indexOfLocalMax = -1;
        while (maxMap.size() < 3) {
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    if (!maxMap.containsKey(i)) {
                        max = array[i];
                        indexOfLocalMax = i;
                    }
                }
            }

            maxMap.put(indexOfLocalMax, max);
            max = Integer.MIN_VALUE;
            indexOfLocalMax = -1;
        }

        int[] threeLargestNumbers = new int[3];

        int i = 0;
        Iterator maxMapIterator = maxMap.entrySet().iterator();

        while(maxMapIterator.hasNext()){
            Map.Entry pair = (Map.Entry) maxMapIterator.next();
            threeLargestNumbers[i] = (int)pair.getValue();
            i++;
        }


        Arrays.sort(threeLargestNumbers);
        return threeLargestNumbers;
    }
}
