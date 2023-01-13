package com.todoapplication.todolist.lists;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.todoapplication.todolist.service.ListService;
import com.todoapplication.todolist.model.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoListApplicationHttpRequestTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ListService ListService;

    // get
    @Test
    void GetallLists() throws Exception{
        this.mockMvc.perform(get("/lists")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void GetListOnID() throws Exception{
        this.mockMvc.perform(get("/lists/")
                .param("idlist","1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    // post
    @Test
    void PostListSuccess() throws Exception{
        this.mockMvc.perform(post("/lists/")
                .content(asJsonString(new List(1,"newList","ListType")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void PostListBadRequest() throws Exception{
        this.mockMvc.perform(post("/lists/")
                        .content("invalid_payload")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    // put
    @Test
    void PutListSuccess() throws Exception{
        this.mockMvc.perform(put("/lists/{idlist}",1)
                        .content(asJsonString(new List(1,"putlist","putType")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    // delete
    @Test
    void DeleteListSuccess() throws Exception{
        this.mockMvc.perform(delete("/lists/{idlist}",1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
