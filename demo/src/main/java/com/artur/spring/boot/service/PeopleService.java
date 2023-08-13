package com.artur.spring.boot.service;

import com.artur.spring.boot.dto.response.PeopleResponseDto;
import com.artur.spring.boot.model.entity.People;
import com.artur.spring.boot.model.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    @Autowired
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleResponseDto> getPeoples() {
        return peopleRepository.findAll().stream().map(PeopleResponseDto::createDto).collect(Collectors.toList());
    }

    public void addPeople(People people){
        if(peopleRepository.findByFirstNameAndLastNameAndPatronymicAndBirthday(people.getFirstName(), people.getLastName(), people.getPatronymic(), people.getBirthday()) != null){
            System.out.println("Такой человек уже существует");
        }
        peopleRepository.save(people);
        System.out.println("Человек успешно сохранен");
    }

    public void deletePeople(Long id) {
       boolean exists = peopleRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException("Человек с таким id" + id + " не существует");
       }
       peopleRepository.deleteById(id);
    }
}
