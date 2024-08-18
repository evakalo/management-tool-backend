package com.example.managementtool.controller;

import com.example.managementtool.model.Card;
import com.example.managementtool.model.ListEntity;
import com.example.managementtool.repository.BoardRepository;
import com.example.managementtool.repository.CardRepository;
import com.example.managementtool.repository.ListEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ListEntityRepository listEntityRepository;

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        if (card.getList() != null && card.getList().getId() != null) {
            ListEntity listEntity = listEntityRepository.findById(card.getList().getId())
                    .orElseThrow(() -> new RuntimeException("List not found"));
            card.setList(listEntity);
        }

        Card savedCard = cardRepository.save(card);
        return ResponseEntity.ok(savedCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return cardRepository.findById(id)
                .map(card -> ResponseEntity.ok().body(card))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
