/**HackerRank challenge */

package com.self;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args){
        /*
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};
        */

        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};
        checkMagazine(magazine, note);
    }

    public static void checkMagazine(String[] magazine, String[] note){
        //border case: if ransom note is longer than magazine, then print No
        if(magazine.length < note.length){
            System.out.println("No");
            return;
        }
        
        Map<String, Integer> auxiliaryMap = new HashMap<>();
    
        //populate auxiliaryMap with word count of each word in the magazine
        for(String word : magazine){
            if(!auxiliaryMap.containsKey(word)){
                auxiliaryMap.put(word, 1);
            }else{
                int count = auxiliaryMap.get(word);
                count++;
                auxiliaryMap.put(word, count);
            }
        }

        //iterate through each word required in the note and check whether it exists
        //in auxiliaryMap. If it exists, then decrement the corresponding value in the map.
        //If it does not exist, then print No.
        //If the value for any word in the map is <0, then print No.
        for(String word : note){
            if(auxiliaryMap.containsKey(word)){
                int count = auxiliaryMap.get(word);
                if(count-1 <0){
                    System.out.println("No");
                    return;
                }
                auxiliaryMap.replace(word, count, count-1);

            }else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }
}
