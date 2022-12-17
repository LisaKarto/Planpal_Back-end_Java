package com.TodoListApplication.TodoList.Service;

import com.TodoListApplication.TodoList.model.ListModel;
import com.TodoListApplication.TodoList.Repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class ListService {
    @Autowired
    private ListRepository listRepository;

    public java.util.List<ListModel> ShowAllLists() {
        return listRepository.findAll();
    }

    public void saveList(ListModel listModel) {
        listRepository.save(listModel);
    }

    public ListModel getList(Integer idlist) {
        return listRepository.findById(idlist).get();
    }

    public void deleteList(Integer idlist) {
        listRepository.deleteById(idlist);
    }
}
