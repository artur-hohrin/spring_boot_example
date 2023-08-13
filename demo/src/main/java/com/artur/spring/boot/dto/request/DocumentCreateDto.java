package com.artur.spring.boot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {

    private Integer series;
    private Integer number;
    private LocalDate date;
}
