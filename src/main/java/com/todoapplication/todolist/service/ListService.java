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
import java.util.Iterator;
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
        // add new fields to builder
        List list = List.builder()
                .idList(listRequest.getIdList())
                .listName(listRequest.getListName())
                .listType(listRequest.getListType())
                // new fields
                .UID(listRequest.getUID())
                .isDone(listRequest.getIsDone())
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
                // new fields
                .UID(listRequest.getUID())
                .isDone(listRequest.getIsDone())
                .build();
        listRepository.save(list);
    }

// get all
    public java.util.List<ListResponse> showAllLists() {
        java.util.List<List> lists = listRepository.findAll();

        return lists.stream().map(this::mapToListResponse).collect(Collectors.toList());
    }
// get lists from user
    public java.util.List<ListResponse> filterLists(java.util.List<ListResponse> userlists,String UID){

        Iterator<ListResponse> i = userlists.iterator();
        while (((Iterator<?>) i).hasNext()) {
            ListResponse s = i.next();
            // do not show list if uid is null or is not equal to the given UID
            if(s.getUID() == null  || !s.getUID().equals(UID)) {
                i.remove();
            }
        }
        return userlists;
    }

    public java.util.List<ListResponse> ShowAllListsFromUser(String UID){
        java.util.List<List> lists = listRepository.findAll();
        java.util.List<ListResponse> userlists = lists.stream().map(this::mapToListResponse).collect(Collectors.toList());
        return filterLists(userlists,UID);
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
                // new fields
                .UID(listModel.getUID())
                .isDone(listModel.getIsDone())
                .build();
}

}
