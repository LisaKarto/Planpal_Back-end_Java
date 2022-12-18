package com.todoapplication.todolist.repository;

import com.todoapplication.todolist.model.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListModel, Integer>{
}
