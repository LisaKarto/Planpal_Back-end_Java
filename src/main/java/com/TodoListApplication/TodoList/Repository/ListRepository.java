package com.TodoListApplication.TodoList.Repository;

import com.TodoListApplication.TodoList.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Integer>{
}
