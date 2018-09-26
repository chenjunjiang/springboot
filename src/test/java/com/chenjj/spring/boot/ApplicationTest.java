package com.chenjj.spring.boot;

import com.chenjj.spring.boot.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 如果ApplicationTest所在的包和Application所在包是一样的，那就不需要指定classes = {Application.class}
 * 如果它们所在包不一样就需要指定classes = {Application.class}
 * <p>
 * x @SpringBootTest 和 @ContextConfiguration 都可以指定classes
 */
@RunWith(SpringRunner.class)
@SpringBootTest(/*classes = {Application.class}, */webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Application.class})
public class ApplicationTest {
    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        this.url = new URL("http://localhost:" + port + "/demo/demo1");
    }

    @Test
    public void demo1() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url.toString(), String.class);
        Assert.assertEquals(responseEntity.getBody(), "Hello Boot");
    }
}
