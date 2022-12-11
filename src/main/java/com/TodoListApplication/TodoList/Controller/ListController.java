package com.TodoListApplication.TodoList.Controller;

import com.TodoListApplication.TodoList.model.List;
import com.TodoListApplication.TodoList.Service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    ListService listService;

    @GetMapping("")
    public java.util.List<List> List() {
       return listService.ShowAllLists();
    }

    @GetMapping("/{idlist}")
    public ResponseEntity<List> get(@PathVariable Integer idlist){
        try {
            List list = listService.getList(idlist);
            return new ResponseEntity<List>(list, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody List list)
    {
        listService.saveList(list);
    }
    @PutMapping("/{idlist}")
    public ResponseEntity<?> update(@RequestBody List list, @PathVariable Integer idlist)
    {
        try {
            List existlijst = listService.getList(idlist);
            list.setIdlist(idlist);
            listService.saveList(list);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{idlist}")
    public void delete(@PathVariable Integer idlist){
        listService.deleteList(idlist);
    }
}


