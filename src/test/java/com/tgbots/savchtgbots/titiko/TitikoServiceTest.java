package com.tgbots.savchtgbots.titiko;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TitikoServiceTest {

    @Autowired
    private TitikoService titikoService;

    @Test
    public void testTest() {
        String serviceToken = titikoService.getToken();
        assertNotNull( serviceToken );
        assertEquals( "ahaha", serviceToken);
    }
}
