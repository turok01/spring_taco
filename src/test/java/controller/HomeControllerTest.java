//package com.Igor.spring_taco;
package controller;
import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.Igor.spring_taco.controller.HomeController;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest(classes = HomeController.class)
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@ContextConfiguration(classes={HomeController.class})
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc; //injects MockMvc
    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // performs GET /
                .andExpect(status().isOk()) //expects HTTP 200
                .andExpect(view().name("home")) //expects home view
                .andExpect(content().string(
                        containsString("Welcome to..."))); //expect Welcom to...
    }
}
