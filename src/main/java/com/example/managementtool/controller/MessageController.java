package com.example.managementtool.controller;

import com.example.managementtool.model.Card;
import com.example.managementtool.model.Message;
import com.example.managementtool.repository.CardRepository;
import com.example.managementtool.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private CardRepository cardRepository;


    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        if (message.getCard() != null && message.getCard().getId() != null) {
            Card card = cardRepository.findById(message.getCard().getId())
                    .orElseThrow(() -> new RuntimeException("Card not found"));
            message.setCard(card);
        }

        Message savedMessage = messageRepository.save(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        return messageRepository.findById(id)
                .map(message -> ResponseEntity.ok().body(message))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
