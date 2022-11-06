package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1) Processes the service request
 * 2) Returns error message as applicable
 *
 */
@Service
public class DemoService {

    /**
     * Prints a list of numbers up to and including 'count'
     * For each multiple of 3, print "Foo" instead of the number
     * For each multiple of 5, print "Bar" instead of the number
     * For numbers that are multiples of both 3 and 5, print "FooBar" instead of the number
     *
     * @param count - The maximum limit of numbers to printed
     * @return List of strings
     *
     */
    public String generateNumberList(Integer count) {

        for (int i=1; i <= count; i++){
            if(i%5==0 && i%3==0){
                System.out.println("FooBar");
            }
            else if(i%3==0){
                System.out.println("Foo");
            }
            else if(i%5==0){
                System.out.println("Bar");
            }
            else{
                System.out.println(i);
            }
        }

        return "Success! Please see console for output.";
    }

    /**
     * Returns top n elements from the input array
     *
     * @param inputArray - The maximum limit of numbers to printed
     * @return List of strings
     *
     */
    public List<Integer> getTopArrayElements(String[] inputArray, String top) {

        Integer limit = Integer.parseInt(top);
        Integer[] intArray = new Integer[inputArray.length];
        for (int i=0; i < inputArray.length;i++) {
            intArray[i] = Integer.parseInt(inputArray[i]);
        }

        List<Integer> intList = Arrays.asList(intArray);

        // If the array size is more than the value of 'top', then limit response to the requested number
        // If the array size is less than the value of 'top', then return all items in sorted order
        // It is assumed that array will not contain any duplicates
        if (intList.size() > limit) {
            return (intList.stream().sorted(Comparator.reverseOrder()).limit(limit).collect(Collectors.toList()));
        } else {
            return (intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        }
    }

    /**
     * Check if two strings are anagrams
     *
     * @param string1 - Input string 1
     * @param string2 - Input string 2
     * @return String
     *
     */
    public String checkIfAnagram(String string1, String string2) {

        // If strings are of different length, then these are not anagrams
        if (string1.length() != string2.length()) {
            return "The strings are not anagrams!";
        }

        // If strings are of same length, convert these to arrays
        // Sort these and compare character by character
        // If the input strings are anagrams, then respective characters from sorted arrays will match
        char[] string1Array = string1.toCharArray();
        char[] string2Array = string2.toCharArray();

        Arrays.sort(string1Array);
        Arrays.sort(string2Array);

        for (int i=0; i < string1.length(); i++) {
            if (string1Array[i] != string2Array[i]) {
                return "The strings are not anagrams!";
            }
        }

        return "The strings are anagrams!";

    }

}
