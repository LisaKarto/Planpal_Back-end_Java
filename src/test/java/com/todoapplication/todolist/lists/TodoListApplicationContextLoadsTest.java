package com.todoapplication.todolist.lists;

import static org.assertj.core.api.Assertions.assertThat;

import com.todoapplication.todolist.controller.ListController;
import com.todoapplication.todolist.repository.ListRepository;
import com.todoapplication.todolist.service.ListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
//@DataJpaTest
class TodoListApplicationContextLoadsTest {
	@Autowired
	private ListController TestListController;
	@Autowired
	private ListService TestListService;
	@Autowired
	private ListRepository TestListRepository;
	@Autowired
	private DataSource TestdataSource;

	@Test
	void contextLoads() {
		assertThat(TestListController).isNotNull();
		assertThat(TestListService).isNotNull();
		assertThat(TestListRepository).isNotNull();
		assertThat(TestdataSource).isNotNull();
	}

}
