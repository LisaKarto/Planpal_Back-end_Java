package com.todoapplication.todolist.controller;

import com.todoapplication.todolist.model.ListModel;
import com.todoapplication.todolist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@CrossOrigin(origins = CORSWhiteList.VUEFRONTEND, allowedHeaders = "*")
@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    ListService listService;

    @GetMapping("")
    public java.util.List<ListModel> List() {
       return listService.ShowAllLists();
    }

    @GetMapping("/{idlist}")
    public ResponseEntity<ListModel> get(@PathVariable Integer idlist){
        try {
            ListModel listModel = listService.getList(idlist);
            return new ResponseEntity<ListModel>(listModel, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<ListModel>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody ListModel listModel)
    {
        try {
            listService.saveList(listModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{idlist}")
    public ResponseEntity<?> update(@RequestBody ListModel listModel, @PathVariable Integer idlist)
    {
        try {
            ListModel existlijst = listService.getList(idlist);
            listModel.setIdlist(idlist);
            listService.saveList(listModel);
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

