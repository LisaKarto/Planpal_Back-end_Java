package com.TodoListApplication.TodoList.Service;

import com.TodoListApplication.TodoList.model.Lijst;
import com.TodoListApplication.TodoList.Repository.LijstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class LijstService {
    @Autowired
    private LijstRepository lijstRepository;

    public List<Lijst> SchermAlleLijsten() {
        return lijstRepository.findAll();
    }

    public void saveLijst(Lijst lijst) {
        lijstRepository.save(lijst);
    }

    public Lijst krijgLijst(Integer idlijst) {
        return lijstRepository.findById(idlijst).get();
    }

    public void verwijderLijst(Integer idlijst) {
        lijstRepository.deleteById(idlijst);
    }
}
