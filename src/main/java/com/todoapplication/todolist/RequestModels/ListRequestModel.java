package com.todoapplication.todolist.RequestModels;


public class ListRequestModel {

    private int idList;
    private String listName;
    private String listType;

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
