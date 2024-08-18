package com.example.managementtool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @JsonBackReference
    private Card card;

    // Getter and Setter for 'card'
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

}