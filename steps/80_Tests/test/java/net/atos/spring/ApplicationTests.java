package net.atos.spring;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired WebApplicationContext webApplicationContext;
    @Autowired MockHttpSession mockHttpSession;
    @Autowired MockHttpServletRequest mockHttpServletRequest;

    private MockMvc mockMvc;

    String author = "author name";
    String content = "Lorem ipsum";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void greetingTest1WithoutName() throws Exception {
        this.mockMvc.perform(get("/greetingjson")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(1)))
            .andExpect(jsonPath("$.content", equalTo("Hello, World!")))
            .andExpect(jsonPath("$", hasKey("date")));
    }

    @Test
    public void greetingTest2WithName() throws Exception {
        this.mockMvc.perform(get("/greetingjson?name=Atos")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", equalTo(2)))
            .andExpect(jsonPath("$.content", equalTo("Hello, Atos!")))
            .andExpect(jsonPath("$", hasKey("date")));
    }

    @Test
    public void guestbookTest1Empty() throws Exception {
        this.mockMvc.perform(get("/guestbook/getall")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void guestbookTest2AddEntry() throws Exception {

        this.mockMvc
            .perform(post("/guestbook/add").
                param("author", author).
                param("content", content)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.author.name", equalTo(author)))
            .andExpect(jsonPath("$.content", equalTo(content)));
    }

    @Test
    public void guestbookTest3Empty() throws Exception {
        this.mockMvc.perform(get("/guestbook/getall")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void guestbookTest4AddIncorrectEntry() throws Exception {

        this.mockMvc
            .perform(post("/guestbook/add").
                param("content", content)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError());
    }
}
