package com.example.managementtool.controller;

import com.example.managementtool.model.Board;
import com.example.managementtool.model.ListEntity;
import com.example.managementtool.repository.BoardRepository;
import com.example.managementtool.repository.ListEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")

@RestController
@RequestMapping("/lists")
public class ListEntityController {

    @Autowired
    private ListEntityRepository listEntityRepository;
    @Autowired
    private BoardRepository boardRepository;
    @GetMapping
    public List<ListEntity> getAllLists() {
        return listEntityRepository.findAll();
    }

    @PostMapping
    public ListEntity createList(@RequestBody ListEntity listEntity) {
        if (listEntity.getBoard() != null && listEntity.getBoard().getId() != null) {
            Board board = boardRepository.findById(listEntity.getBoard().getId())
                    .orElseThrow(() -> new RuntimeException("Board not found with id " + listEntity.getBoard().getId()));
            listEntity.setBoard(board);
        }
        return listEntityRepository.save(listEntity);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ListEntity> getListById(@PathVariable Long id) {
        return listEntityRepository.findById(id)
                .map(listEntity -> ResponseEntity.ok().body(listEntity))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        listEntityRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
