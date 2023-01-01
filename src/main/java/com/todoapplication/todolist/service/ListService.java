package com.todoapplication.todolist.service;

import com.todoapplication.todolist.model.ListModel;
import com.todoapplication.todolist.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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
        return listRepository.findById(idlist).orElse(null);
    }
    
    public void deleteList(Integer idlist) {
        listRepository.deleteById(idlist);
    }
}
