package com.example.managementtool.controller;

import com.example.managementtool.model.Board;
import com.example.managementtool.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @PostMapping

    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        return boardRepository.findById(id)
                .map(board -> ResponseEntity.ok().body(board))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
