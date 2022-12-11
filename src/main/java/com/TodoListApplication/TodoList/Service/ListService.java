package com.TodoListApplication.TodoList.Service;

import com.TodoListApplication.TodoList.model.List;
import com.TodoListApplication.TodoList.Repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class ListService {
    @Autowired
    private ListRepository listRepository;

    public java.util.List<List> ShowAllLists() {
        return listRepository.findAll();
    }

    public void saveList(List list) {
        listRepository.save(list);
    }

    public List getList(Integer idlist) {
        return listRepository.findById(idlist).get();
    }

    public void deleteList(Integer idlist) {
        listRepository.deleteById(idlist);
    }
}
