package com.dove.Dove_user_backend.controller;

import com.dove.Dove_user_backend.DoveUserBackendApplication;
import com.dove.Dove_user_backend.entity.post.Post;
import com.dove.Dove_user_backend.entity.post.PostRepository;
import com.dove.Dove_user_backend.payload.request.PostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DoveUserBackendApplication.class)
@ActiveProfiles("test")
class PostControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private PostRepository postRepository;

    private MockMvc mvc;

    @BeforeEach
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void after() {
        postRepository.deleteAll();
    }

    @Test
    public void viewList() throws Exception {
        postPost(1);
        postPost(2);
        postPost(3);
        postPost(4);
        postPost(5);
        postPost(6);
        postPost(7);
        postPost(8);

        mvc.perform(get("/")
                .param("size","6")
                .param("page","0"))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void viewPost() throws Exception {
        int id = postPost(10);
        postPost(11);

        mvc.perform(get("/post/"+id))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void addPost() throws Exception {
        PostRequest request = PostRequest.builder()
                .clubName("submit")
                .title("event")
                .description("event description")
                .writer("이승윤")
                .date("2019-01-19")
                .link("http://github.com/syxxn")
                .build();

        mvc.perform(post("/post")
                .content(new ObjectMapper()
                        .writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    private Integer postPost(Integer id) {
        return  postRepository.save(
                Post.builder()
                        .clubName("club"+id)
                        .title("event")
                        .description("event description")
                        .writer("이승윤")
                        .eventDate(LocalDate.parse("2019-01-19"))
                        .link("http://github.com/syxxn")
                        .build()
        ).getId();
    }

}
