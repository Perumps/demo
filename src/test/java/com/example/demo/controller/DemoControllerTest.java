package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerTest {

    @MockBean
    DemoService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void foobarTest() throws Exception {
        Mockito.when(service.generateNumberList(Mockito.anyInt())).
                thenReturn("Success! Please see console for output.");

        MvcResult result = mvc.perform(get("/foobar")
                        .queryParam("count", "100"))
                .andReturn();
        assertEquals("Success! Please see console for output.", result.getResponse().getContentAsString());
    }

    @Test
    public void returnTopArrayElementsTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        Mockito.when(service.getTopArrayElements(Mockito.any(), Mockito.anyString())).
                thenReturn(list);

        MvcResult result = mvc.perform(get("/sort")
                        .queryParam("inputArray", "1,2,3").queryParam("top", "2"))
                .andReturn();
        System.out.println(result.getResponse());
        assertEquals("[2,1]", result.getResponse().getContentAsString());
    }

    @Test
    public void anagramTest() throws Exception {
        Mockito.when(service.checkIfAnagram(Mockito.anyString(), Mockito.anyString())).
                thenReturn("The strings are anagrams!");

        MvcResult result = mvc.perform(get("/anagram")
                        .queryParam("string1", "ABC").queryParam("string2", "BAC"))
                .andReturn();
        assertEquals("The strings are anagrams!", result.getResponse().getContentAsString());
    }

}