package com.artur.spring.boot.dto.response;

import com.artur.spring.boot.model.entity.Document;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DocumentResponseDto {

    private Integer series;
    private Integer number;
    private LocalDate date;

    public static DocumentResponseDto createDocumentDto(Document document){
        DocumentResponseDto documentResponseDto = new DocumentResponseDto();
        documentResponseDto.setSeries(document.getSeries());
        documentResponseDto.setNumber(document.getNumber());
        documentResponseDto.setDate(document.getDate());
        return documentResponseDto;
    }
}
