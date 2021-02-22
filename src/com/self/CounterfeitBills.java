package com.self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CounterfeitBills {
    public static void main(String[] args){
        List<String> serialNumbers = new ArrayList<>();
        serialNumbers.add("DY19");
        serialNumbers.add("ABB19991000Z");
        serialNumbers.add("ABC19991000Z");

        int sum = countCounterfeit(serialNumbers);
        System.out.println("Sum "+ sum);
    }

    public static boolean checkUpperCaseAToZ(String inputString){
        Set<Character> set = new HashSet<>();
        char[] inputAsCharacters = inputString.toCharArray();
        for(int i=0; i<inputAsCharacters.length; i++){
            if(!Character.isUpperCase(inputAsCharacters[i])){
                return false;
            }
            if(set.contains(inputAsCharacters[i])){
                return false;
            }
            set.add(inputAsCharacters[i]);
        }
        return true;
    }

    public static int countCounterfeit(List<String> serialNumber) {
        // Write your code here
            int sum = 0;
            for(int i=0; i<serialNumber.size(); i++){
                String currentSerial = serialNumber.get(i);
                //check validity of currentSerial
                if(currentSerial.length()>=10 && currentSerial.length()<=12){
                    String firstThree = currentSerial.substring(0,3);
                    //check that firstThree contains uppercase distinct English alphabets
                    if(checkUpperCaseAToZ(firstThree)){
                        //check whether the next four characters represent year 1900-2019 inclusive
                        int year = Integer.parseInt(currentSerial.substring(3,7));
                        if(year>=1900 && year<=2019){
                            //check the next two, three or four characters represent valid denominations
                            //if currentSerial has 10 characters, then only next two characters should be 
                            //denominations
                            if(currentSerial.length()==10){
                                String twoDigitDenomination = currentSerial.substring(7,9);
                                if(twoDigitDenomination.equals("10") || twoDigitDenomination.equals("20") ||twoDigitDenomination.equals("50")){
                                    int denomination = Integer.parseInt(twoDigitDenomination);
                                    //check whether the last character is uppercase English letter
                                    Character lastChar = currentSerial.charAt(9);
                                    if(Character.isUpperCase(lastChar)){
                                        sum += denomination;
                                    }else{
                                        continue;
                                    }
                                }else{
                                    continue;
                                }
                            }
                            //if currentSerial is 11 characters, then next three should be denominations
                            if(currentSerial.length()==11){
                                String threeDigitDenomination = currentSerial.substring(7,10);
                                if(threeDigitDenomination.equals("100")||threeDigitDenomination.equals("200")||threeDigitDenomination.equals("500")){
                                    //check last character
                                    int denomination = Integer.parseInt(threeDigitDenomination);
                                    Character lastChar = currentSerial.charAt(10);
                                    if(Character.isUpperCase(lastChar)){
                                        sum += denomination;
                                    }else{
                                        continue;
                                    }
                                }
                            }
                            //if currentSerial is 12 characters, then next four should be denominations
                            if(currentSerial.length()==12){
                                String fourDigitDenomination = currentSerial.substring(7,11);
                                if(fourDigitDenomination.equals("1000")){
                                    //check last character
                                    int denomination = Integer.parseInt(fourDigitDenomination);
                                    Character lastChar = currentSerial.charAt(11);
                                    if(Character.isUpperCase(lastChar)){
                                        sum += denomination;
                                    }else{
                                        continue;
                                    }
                                }else{
                                    continue;
                                }
                            }
                        }
                        
                        
                    }
                }else{//currentSerial is invalid due to wrong length, so move on
                    continue;
                }
            }
            
            
            return sum;
        }
}
