package com.artur.spring.boot.model.entity;

import com.artur.spring.boot.dto.request.PeopleCreateDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "people")
@Accessors(chain = true)
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "sex")
    private String sex;
    @OneToMany(mappedBy = "people", fetch = FetchType.LAZY)
    private List<Document> documents;

    public Integer getAge(){
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public static People createModelPeople(PeopleCreateDto createDto) {
        return new People().setFirstName(createDto.getFirstName()).setLastName(createDto.getLastName()).setPatronymic(createDto.getPatronymic()).setBirthday(createDto.getBirthday()).setSex(createDto.getSex());
    }
}
