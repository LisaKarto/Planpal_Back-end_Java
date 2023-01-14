package com.todoapplication.todolist.lists;

import com.todoapplication.todolist.dto.ListResponse;
import com.todoapplication.todolist.repository.ListRepository;
import com.todoapplication.todolist.service.ListService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestService {

    @Autowired
    ListService listService;

    @MockBean
    ListRepository listRepository;

    @Test
    public void TestShowListsFromUser(){

        com.todoapplication.todolist.model.List list1 = new com.todoapplication.todolist.model.List();
        list1.setIdList(1);
        list1.setListName("My first list from user 1");
        list1.setListType("Todo-list");
        list1.setUID("user1");
        list1.setIsDone(0);

        com.todoapplication.todolist.model.List list2 = new com.todoapplication.todolist.model.List();
        list2.setIdList(2);
        list2.setListName("My first list from user 1");
        list2.setListType("Todo-list");
        list2.setUID("user1");
        list2.setIsDone(0);

        com.todoapplication.todolist.model.List list3 = new com.todoapplication.todolist.model.List();
        list3.setIdList(3);
        list3.setListName("My first list from user 2");
        list3.setListType("Todo-list");
        list3.setUID("user2");
        list3.setIsDone(0);

        List<com.todoapplication.todolist.model.List> lists = Arrays.asList(list1,list2,list3);

        Mockito.when(listRepository.findAll()).thenReturn(lists);

        List<ListResponse> userlists = listService.ShowAllListsFromUser("user2");
        // check the array size, there's only one list from user 2 the others have been removed from the list
        assertThat(userlists.size()).isEqualTo(1);
        // check if their uids are equal
        assertThat(userlists.get(0).getUID()).isEqualTo(list3.getUID());

    }

}
