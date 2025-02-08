package com.chenjj.spring.boot;

import com.chenjj.spring.boot.model.User;
import com.chenjj.spring.boot.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 如果ApplicationTest所在的包和Application所在包是一样的，那就不需要指定classes = {Application.class}
 * 如果它们所在包不一样就需要指定classes = {Application.class}
 * <p>
 * x @SpringBootTest 和 @ContextConfiguration 都可以指定classes
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/*@ContextConfiguration(classes = {Application.class})*/
public class ApplicationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * @MockBean 注解，就声明了对应类型的一个mock bean。如果spring上下文中已经存在对应类型的bean，将会被mock bean覆盖掉。
     * https://www.cnblogs.com/ywjy/p/9997412.html
     */
    //@MockBean
    private UserService userService;
    /*@LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        this.url = new URL("http://localhost:" + port + "/demo");
    }

    @Test
    public void demo1() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(url.toString(), String.class);
        Assert.assertEquals(responseEntity.getBody(), "Hello Boot");
    }*/

    @Before
    public void setUp() throws Exception {
        //MockMvcBuilders.webAppContextSetup(WebApplicationContext context)：指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void getUserById() throws Exception {
        Mockito.when(userService.get(Mockito.any())).thenReturn(new User("lisi", "654321"));
        //Mockito.when(userService.get(anyInt())).thenReturn(new User("lisi", "654321"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                .param("name", "lvgang")
                .accept(MediaType.APPLICATION_JSON))
                // .andExpect(MockMvcResultMatchers.status().isOk())             //等同于Assert.assertEquals(200,status);
                // .andExpect(MockMvcResultMatchers.content().string("hello lvgang"))    //等同于 Assert.assertEquals("hello lvgang",content);
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();                 //得到返回代码
        String content = mvcResult.getResponse().getContentAsString();    //得到返回结果

        Assert.assertEquals(200, status);                        //断言，判断返回代码是否正确
        Assert.assertEquals("hello lvgang", content);            //断言，判断返回的值是否正确
    }
}
