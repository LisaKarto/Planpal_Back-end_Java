package com.TodoListApplication.TodoList.lists;
import com.TodoListApplication.TodoList.Controller.ListController;
import com.TodoListApplication.TodoList.Repository.ListRepository;
import com.TodoListApplication.TodoList.Service.ListService;
import com.TodoListApplication.TodoList.model.ListModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TodoListApplicationIntegrationTest
{
    @Autowired
    ListService service;
    @Autowired
    ListRepository repository;

    // post
    @Test
     void insertListIntoDatabase() throws Exception{
        ListModel ListToBeSaved = new ListModel(1,"List from Test","IntegrationTest");
        service.saveList(ListToBeSaved);
        assertThat(service.getList(1)).isNotNull();
    }
    // get by id
    @Test
     void getListByID() throws Exception{
        assertThat(service.getList(1)).isNotNull();
    }

}
