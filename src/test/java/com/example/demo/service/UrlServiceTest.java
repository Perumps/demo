package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest {

/*    @Mock
    UrlRepository repository;*/

    @InjectMocks
    DemoService service;

/*    @Test
    public void retrieveLongUrl() throws Exception {
        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.empty().of(entity));
        assertEquals("www.google.com", service.retrieveLongUrl("1f63b7d1"));
    }*/
}