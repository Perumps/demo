package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DemoServiceTest {

    DemoService service = new DemoService();

    @Test
    public void generateNumberListTest() {
        assertEquals("Success! Please see console for output.", service.generateNumberList(16));
    }

    @Test
    public void getTopArrayElementsSizeGTTopTest() {
        String[] array = {"1", "3", "2"};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        assertEquals(list, service.getTopArrayElements(array, "2"));
    }

    @Test
    public void getTopArrayElementsSizeEQTopTest() {
        String[] array = {"1", "3", "2"};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        assertEquals(list, service.getTopArrayElements(array, "3"));
    }

    @Test
    public void getTopArrayElementsSizeLTTopTest() {
        String[] array = {"1", "3", "2"};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        assertEquals(list, service.getTopArrayElements(array, "4"));
    }

    @Test
    public void checkIfAnagramDiffLengthTest() {
        assertEquals("The strings are not anagrams!", service.checkIfAnagram("ABCD", "BAC"));
    }

    @Test
    public void checkIfAnagramSameLengthFalse() {
        assertEquals("The strings are not anagrams!", service.checkIfAnagram("ABD", "BAC"));
    }

    @Test
    public void checkIfAnagramSameLengthTrue() {
        assertEquals("The strings are anagrams!", service.checkIfAnagram("ABC", "BAC"));
    }
}