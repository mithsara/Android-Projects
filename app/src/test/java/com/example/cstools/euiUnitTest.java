package com.example.cstools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class euiUnitTest {
    private eui64_HomeActivity eui64_HomeActivityIns;

    @Before
    public void setup(){
        eui64_HomeActivityIns = new eui64_HomeActivity();
    }

    @Test
    public void Test1(){
        String result =eui64_HomeActivityIns.euiProcess("39A794","07CBD0");
        assertEquals("3BA794FFFE07CBD0",result);
    }
}
