package com.todoapplication.todolist.service;

import com.todoapplication.todolist.dto.ListRequest;
import com.todoapplication.todolist.dto.ListResponse;
import com.todoapplication.todolist.model.List;
import com.todoapplication.todolist.repository.ListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ListService {
    @Autowired
    private ListRepository listRepository;
// create
    public void saveList(ListRequest listRequest) {
        List list = List.builder()
                .idList(listRequest.getIdList())
                .listName(listRequest.getListName())
                .listType(listRequest.getListType())
                .build();
        listRepository.save(list);
    }
// update
    public void saveList(ListRequest listRequest, int idlist)
    {
        listRequest.setIdList(idlist);
        List list = List.builder()
                .idList(listRequest.getIdList())
                .listName(listRequest.getListName())
                .listType(listRequest.getListType())
                .build();
        listRepository.save(list);
    }

// get all
    public java.util.List<ListResponse> showAllLists() {
        java.util.List<List> lists = listRepository.findAll();

        return lists.stream().map(this::mapToListResponse).collect(Collectors.toList());
    }
// get single
    public List getList(Integer idlist) {
        return listRepository.findById(idlist).orElse(null);
    }
// delete
    public void deleteList(Integer idlist) {
        listRepository.deleteById(idlist);
    }
// map
private ListResponse mapToListResponse(List listModel){
        return ListResponse.builder()
                .idList(listModel.getIdList())
                .listName(listModel.getListName())
                .listType(listModel.getListType())
                .build();
}

}
