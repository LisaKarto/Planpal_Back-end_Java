package com.todoapplication.todolist.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "list")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class List {
    @Id
    private int idList;
    private String listName;
    private String listType;
}
