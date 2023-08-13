package com.artur.spring.boot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "type_document")
@Data
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
