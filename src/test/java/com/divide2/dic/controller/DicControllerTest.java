package com.divide2.dic.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by bvvy on 2018/1/4.
 * com.divide2.dic.controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DicControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation
            = new JUnitRestDocumentation("target/generated-snippets");

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }
/**
 * responseFields(
 * fieldWithPath("[].id").type(JsonFieldType.ARRAY).description("id")
 */
    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/v1/dic/list"))
                .andExpect(status().isOk())
                .andDo(document("dic"));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/v1/dic/1"))
                .andExpect(status().isOk())
                .andDo(document("dic", responseFields(
                        fieldWithPath("cnLabel").description("The user's contact details"),
                        fieldWithPath("contact.email").description("The user's email address"))));

    }


}