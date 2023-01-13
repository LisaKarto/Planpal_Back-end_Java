package com.todoapplication.todolist.controller;

import com.todoapplication.todolist.dto.ListRequest;
import com.todoapplication.todolist.dto.ListResponse;
import com.todoapplication.todolist.model.List;
import com.todoapplication.todolist.model.List;
import com.todoapplication.todolist.service.ListService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ListController {

    @Autowired
    ListService listService;

    @GetMapping("")
    public java.util.List<ListResponse> listAll() {
       return listService.showAllLists();
    }

    @GetMapping("/{idlist}")
    public ResponseEntity<List> get(@PathVariable Integer idlist){
        try {
            List requestedList = listService.getList(idlist);
            return new ResponseEntity<>(requestedList, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<List> add(@RequestBody ListRequest listRequest)
    {
        try {
            listService.saveList(listRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{idlist}")
    public ResponseEntity<List> update(@RequestBody ListRequest listRequest, @PathVariable Integer idlist)
    {
        try {
            listService.saveList(listRequest,idlist);
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


