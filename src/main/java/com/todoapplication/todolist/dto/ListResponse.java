package com.todoapplication.todolist.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse {

    private int idList;
    private String listName;
    private String listType;
    private String UID;
    private int isDone;
}
