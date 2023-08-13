package com.artur.spring.boot.model.entity;

import com.artur.spring.boot.dto.request.DocumentCreateDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "documents")
@Accessors(chain = true)
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

    public static Document createModelDocument(DocumentCreateDto createDto){
        return new Document().setSeries(createDto.getSeries()).setNumber(createDto.getNumber()).setDate(createDto.getDate());
    }
}
