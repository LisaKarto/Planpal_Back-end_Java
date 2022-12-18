package com.TodoListApplication.TodoList.Repository;

import com.TodoListApplication.TodoList.model.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListModel, Integer>{
}
