package com.artur.spring.boot.model.repository;

import com.artur.spring.boot.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Document findBySeriesAndNumber (Integer series, Integer number);
}
