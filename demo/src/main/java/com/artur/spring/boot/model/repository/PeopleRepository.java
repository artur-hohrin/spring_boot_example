package com.artur.spring.boot.model.repository;

import com.artur.spring.boot.model.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PeopleRepository extends JpaRepository<People, Long> {
    People findByFirstNameAndLastNameAndPatronymicAndBirthday (String firstName, String lastName, String patronymic, LocalDate birthday);

}
