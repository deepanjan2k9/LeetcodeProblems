/*
You are given a collection of person objects (in a natural manner for the
language you're writing in) with three fields:

{firstName, lastName, age} e.g. {Jane, Smith, 14}

We want to know which family has the longest line of "juniors". 
A family has "juniors" when multiple family members have the same full name.

Consider the following example.
[
    {firstName: "John",  lastName: "Doe",   age: 13},    
    {firstName: "John",  lastName: "Doe",   age: 32},   
    {firstName: "John",  lastName: "Doe",   age: 62},  
    {firstName: "Janet", lastName: "Doe",   age: 14},
    {firstName: "Jenny", lastName: "Smith", age: 34},   
    {firstName: "Jenny", lastName: "Smith", age: 12},  
]

In this example, the Doe family has the longest line of juniors.

Let’s talk about your plan of attack before you start coding, and remember 
to keep talking me through what you are doing as you code.

*/

package com.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Person {
    private String firstName;
    private String lastName;
    private int age;
    
    public Person(String f, String l, int a)
    {
      firstName = f;
      lastName = l;
      age = a;
    }
    
    public String getFirstName()
    {
      return firstName;
    }
    
    public String getLastName()
    {
      return lastName;
    }
    
    public int getAge()
    {
      return age;
    }
    
  }

public class MaxJuniorsInFamily {

    public static void main(String[] args){
        List<Person> persons = new ArrayList<Person>();
        
        persons.add(new Person("Deepanjan", "Das", 13));
        persons.add(new Person("Deepanjan", "Das", 32));
        persons.add(new Person("Henry", "Jenkins", 62));
        persons.add(new Person("Janet", "Doe", 14));
        persons.add(new Person("Jenny", "Smith", 34));
        persons.add(new Person("Jenny", "Smith", 12));

        String familyWithLargetLineOfJuniors = MaxJuniorsInFamily.solution(persons);
        System.out.println("Family with longest line of juniors: " + familyWithLargetLineOfJuniors);
    }
    
    public static String solution(List<Person> persons){
        String nameOfMaxJuniors = "";
        int nameCounter=0;
        //create HashMap where key is fullname (String) and value (Integer) is number of occurrences
        HashMap<String,Integer> occurrencesOfSameFullName = new HashMap<>();

        //populate the Hashmap
        String fullName="";
        
        for (int i=0; i< persons.size(); i++){
            //if fullName is empty then set it to the full name of this person element
            //and also increment the name counter
            if(fullName == ""){
                fullName = persons.get(i).getFirstName() + " " + persons.get(i).getLastName();
                nameCounter++;
            }
            //if fullName is not empty, then
            //if its full name matches the fullName variable
            else if((persons.get(i).getFirstName() + " " + persons.get(i).getLastName()).equals(fullName)){
                nameCounter++;
                occurrencesOfSameFullName.put(fullName, nameCounter);
                
            }
            //if fullName is not empty, and if the current person's full name does not 
            //match the fullName variable
            else{
                nameCounter=0;
                fullName=persons.get(i).getFirstName() + " " + persons.get(i).getLastName();
                
            }
            
        }
            
        
        Iterator mapIterator = occurrencesOfSameFullName.entrySet().iterator();
        int maxValueInMap = 0;
        //find the maximum value in the hashmap
        while(mapIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)mapIterator.next();
            int occurrences = (int)mapElement.getValue();
            if(maxValueInMap < occurrences){
                maxValueInMap = occurrences;
            }
        }
        
        //now that we have the max value, we want to make sure it is >1
        if(maxValueInMap > 1){
            //find the key corresponding to this max value
            for(Entry<String, Integer> entry : occurrencesOfSameFullName.entrySet()){
                if(entry.getValue() == maxValueInMap){
                    nameOfMaxJuniors = entry.getKey();
                }
            }
        }else{
            nameOfMaxJuniors = "None";
        }

        return nameOfMaxJuniors;
    }

}
