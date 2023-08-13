package com.artur.spring.boot.dto.response;

import com.artur.spring.boot.model.entity.People;
import lombok.Data;

@Data
public class PeopleResponseDto {
    private String fio;
    private Integer age;

    public static PeopleResponseDto createDto(People people){
        PeopleResponseDto peopleResponseDto = new PeopleResponseDto();
        peopleResponseDto.setFio(people.getFirstName() + " " + people.getLastName() + " " + people.getPatronymic());
        peopleResponseDto.setAge(people.getAge());
        return peopleResponseDto;
    }
}
