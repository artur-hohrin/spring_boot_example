package com.artur.spring.boot.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "series")
    private Integer series;
    @Column(name = "number")
    private Integer number;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeDocument typeDocument;
    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;
}
