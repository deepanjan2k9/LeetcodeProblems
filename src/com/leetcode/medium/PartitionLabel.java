package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
    public static void main(String[] args){
        String S = "ababcbacadefegdehijhklij";
    }

    public List<Integer> partitionLabels(String S){
        List<Integer> labelSizes = new ArrayList<>();
        
        int length = S.length();
        int currentStartIndex, currentEndIndex = 0;
        char element = ' ';
        while(currentStartIndex < length){
            //element is empty and is initially assigned to first character in the string
            if(element == ' '){
                element = S.charAt(currentStartIndex);
            }
            //find the next occurrence of the element in string
            for(int j=currentStartIndex+1; j<length; j++){
                //second occurrence of the element found, set its position as end index
                if(S.charAt(j) == element){
                    currentEndIndex = j;
                    break;
                }
            }

            //if currentEndIndex is > 0, then 1st candidate partition is substring[currentStartIndex, currentEndIndex]
            //and 2nd candidate partition is the rest of the string
            if(currentEndIndex > 0){
                //we have to check the validity of this 1st candidate partition
                for(int i=currentStartIndex+1; i<=currentEndIndex; i++){
                    char temp = S.charAt(i);
                    for(int k=i+1; k<=currentEndIndex; k++){
                        //we found two occurrences of other element inside this 1st candidate partition
                        //so we need to reconsider starting and ending pointers
                        if(S.charAt(k) == temp){

                        }
                    }

                }
                
                labelSizes.add(currentEndIndex - currentStartIndex + 1);
                //reset currentEndIndex to 0
                currentEndIndex = 0;
                //point currentStartIndex to the next element in the string
                currentStartIndex++;
                //reset element as the next character in the string
                element = S.charAt(currentStartIndex);
            }

            //if currentEndIndex is still 0, then 1st partition is 1st element, second candidate
            //partition is the rest of the string
            if(currentEndIndex == 0){
                labelSizes.add(1);
                currentStartIndex++;
                element = S.charAt(currentStartIndex);
            }
        }


            
            
                
            } 
        }

        return labelSizes;

    }
}
