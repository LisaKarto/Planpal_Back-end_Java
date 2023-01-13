package com.todoapplication.todolist.lists;

import static org.assertj.core.api.Assertions.assertThat;

import com.todoapplication.todolist.controller.ListController;
import com.todoapplication.todolist.repository.ListRepository;
import com.todoapplication.todolist.service.ListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@SpringBootTest
@Testcontainers
class TodoListApplicationContextLoadsTest {

	@Test
	void contextLoads() {

	}

}
