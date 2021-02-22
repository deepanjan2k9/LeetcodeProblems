/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example - 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 */

package com.leetcode.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args){
        LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();
        //String s = "sdsduuhegekhgherlger";
        //String s = "abcabcbb";
        String s = "dvdf";
        System.out.println("Length of longest substring of " + s + " is " + obj.lengthOfLongestSubstring(s));
    }
    
    public int lengthOfLongestSubstring(String s){
        int answer=0;

        //We need two pointers to keep track of window size
        //First pointer iterates over all the characters in the string and is the starting point of sliding window
        //Second pointer comes after the first, and iterates over the rest of the characters in the string,
        //and whenever it encounters a unique character not visited, it stores it in a data structure
        //The second pointer is the other end of the sliding window.

        //data structure to store the substring. We are choosing HashSet because it only stores unique elements
        HashSet<Character> hashSet = new HashSet<>();

        int i=0, j=0; //first and second pointers

        while(j<s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                answer = Math.max(answer, hashSet.size());
                j++;
            }else{
                hashSet.remove(s.charAt(i));
                i++;
            }
        }
        return answer;
    }
}
