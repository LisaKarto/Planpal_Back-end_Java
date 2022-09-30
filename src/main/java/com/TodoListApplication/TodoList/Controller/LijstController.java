package com.TodoListApplication.TodoList.Controller;

import com.TodoListApplication.TodoList.model.Lijst;
import com.TodoListApplication.TodoList.Service.LijstService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lijsten")
public class LijstController {
@Autowired LijstService lijstService;

    @GetMapping("")
    public List<Lijst> List() {
       return lijstService.SchermAlleLijsten();
    }

    @GetMapping("/{idlijst}")
    public ResponseEntity<Lijst> get(@PathVariable Integer idlijst){
        try {
            Lijst lijst = lijstService.krijgLijst(idlijst);
            return new ResponseEntity<Lijst>(lijst, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Lijst>(HttpStatus.NOT_FOUND);
        }
    }
@PostMapping("/")
public void add(@RequestBody Lijst lijst){
        lijstService.saveLijst(lijst);
}
    @PutMapping("/{idlijst}")
    public ResponseEntity<?> update(@RequestBody Lijst lijst, @PathVariable Integer idlijst)
    {
        try {
            Lijst existlijst = lijstService.krijgLijst(idlijst);
            lijst.setIdlijst(idlijst);
            lijstService.saveLijst(lijst);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{idlijst}")
    public void delete(@PathVariable Integer idlijst){
        lijstService.verwijderLijst(idlijst);
    }
}


