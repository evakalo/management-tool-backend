package com.example.managementtool.repository;

import com.example.managementtool.model.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListEntityRepository extends JpaRepository<ListEntity, Long> {
}