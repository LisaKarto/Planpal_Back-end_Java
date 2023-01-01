package com.todoapplication.todolist.model;

import com.todoapplication.todolist.requestmodels.ListRequestModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "lists")
public class ListModel {

    private int idList;
    private String listName;
    private String listType;

    public ListModel() {

    }

    public ListModel(int idList, String listName, String listType) {
        this.idList = idList;
        this.listName = listName;
        this.listType = listType;
    }

    public ListModel(ListRequestModel listRequestModel) {
        this.idList = listRequestModel.idList;
        this.listName = listRequestModel.listName;
        this.listType = listRequestModel.listType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getIdlist() {
        return this.idList;
    }
    public void setIdlist(int idList)
    {
        this.idList = idList;
    }

    public String getlistName(){
        return this.listName;
    }

    public void setlistName(String listname){
        this.listName = listname;
    }

    public String getlistType(){
        return this.listType;
    }

    public void setlistType(String listtype){
        this.listType = listtype;
    }
}
