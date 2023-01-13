package com.todoapplication.todolist.repository;

import com.todoapplication.todolist.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Integer>{
}
