package com.artur.spring.boot.service;

import com.artur.spring.boot.dto.request.PeopleCreateDto;
import com.artur.spring.boot.dto.response.PeopleResponseDto;
import com.artur.spring.boot.exception.PeopleAddException;
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
        return peopleRepository.findAll().stream().map(PeopleResponseDto::createPeopleDto).collect(Collectors.toList());
    }

    public void addPeople(PeopleCreateDto people) throws PeopleAddException {
        if(peopleRepository.findByFirstNameAndLastNameAndPatronymicAndBirthday(people.getFirstName(), people.getLastName(), people.getPatronymic(), people.getBirthday()) != null){
            throw new PeopleAddException("Такой человек уже существует");
        }
        People modelPeople = People.createModelPeople(people);
        peopleRepository.save(modelPeople);
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
