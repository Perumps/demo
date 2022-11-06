package com.example.demo.controller;

import com.example.demo.service.DemoService;
import com.example.demo.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller exposes three REST endpoints.
 *
 * 1) Endpoint /foobar -
 * Accepts a number n as input
 * Prints each number from 1 to 100 on a new line if the request is successful. For each multiple of 3, print "Foo" instead of the number. For each multiple of 5, print "Bar" instead of the number. For numbers that are multiples of both 3 and 5, print "FooBar" instead of the number.
 * Returns an error message if input parameters are missing or invalid
 *
 * 2) Endpoint /sort
 * Accepts an integer array and a number n as input
 * Return the top n elements from the array if the request is successful
 * Returns an error message if input parameters are missing or invalid
 *
 * 3) Endpoint /anagram
 * Accepts two string and checks if those are anagrams
 * Returns a message indicating whether the two strings are anagrams or not, if the request is successful
 * Returns an error message if input parameters are missing or invalid
 */
@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    /**
     * Constructor
     *
     * @param demoService - Demo service invoked
     *
     */
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    /**
     * Foobar Endpoint
     * Returns HTTP Status 200 when successful, with list of numbers or matching replacement text (Foo, Bar or FooBar)
     * Returns error message with HTTP status 400 when input parameter is invalid or missing
     *
     * @param count - count parameter from the input
     * @return ResponseEntity with short URL string
     * @throws Exception Exception
     *
     */
    @GetMapping("/foobar")
    public ResponseEntity<String> generateNumberList(@RequestParam("count") String count) throws Exception {

        ValidationUtil.validateCount(count);
        return new ResponseEntity<>(demoService.generateNumberList(Integer.parseInt(count)),
                new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Sort Endpoint
     * Returns HTTP Status 200 when successful, with list of n top elements from input array
     * Returns error message with HTTP status 400 when input is invalid or missing
     *
     * @param inputArray - input array parameter
     * @param top - top n elements to be returned
     * @return ResponseEntity with top n elements from input array
     * @throws Exception Exception
     *
     */
    @GetMapping("/sort")
    public ResponseEntity<List<Integer>> returnTopArrayElements(@RequestParam("inputArray") String[] inputArray,
                                                         @RequestParam("top") String top) throws Exception {

        ValidationUtil.validateInputArray(inputArray);
        ValidationUtil.validateTop(top);
        return new ResponseEntity<>(demoService.getTopArrayElements(inputArray, top),
                new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Anagram Endpoint
     * Returns HTTP Status 200 when successful, with confirmation on whether the input strings are anagrams
     * Returns error message with HTTP status 400 when input is invalid or missing
     *
     * @param string1 - input string1
     * @param string2 - input string2
     * @return ResponseEntity with confirmation on whether the input strings are anagrams
     * @throws Exception Exception
     *
     */
    @GetMapping("/anagram")
    public ResponseEntity<String> checkIfAnagram(@RequestParam("string1") String string1,
                                                 @RequestParam("string2") String string2) throws Exception {

        ValidationUtil.validateInputStrings(string1, string2);
        return new ResponseEntity<>(demoService.checkIfAnagram(string1, string2),
                new HttpHeaders(), HttpStatus.OK);
    }

}
