package com.TodoListApplication.TodoList.Repository;

import com.TodoListApplication.TodoList.model.Lijst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<Lijst, Integer>{
}
