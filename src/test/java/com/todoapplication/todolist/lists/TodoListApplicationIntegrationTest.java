package com.todoapplication.todolist.lists;
import com.todoapplication.todolist.repository.ListRepository;
import com.todoapplication.todolist.service.ListService;
import com.todoapplication.todolist.model.ListModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
