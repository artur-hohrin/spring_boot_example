package com.artur.spring.boot.controller;

import com.artur.spring.boot.dto.request.PeopleCreateDto;
import com.artur.spring.boot.dto.response.PeopleResponseDto;
import com.artur.spring.boot.exception.PeopleAddException;
import com.artur.spring.boot.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/all")
    public List<PeopleResponseDto> getPeoples(){
       return peopleService.getPeoples();
    }

    @PostMapping
    public void addPeople(@RequestBody PeopleCreateDto people) throws PeopleAddException {
        peopleService.addPeople(people);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePeople(@PathVariable Long id){
        peopleService.deletePeople(id);
    }
}
