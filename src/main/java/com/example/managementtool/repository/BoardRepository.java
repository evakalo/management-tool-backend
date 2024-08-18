package com.example.managementtool.repository;

import com.example.managementtool.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // No additional code is needed here; JpaRepository provides basic CRUD operations.
}