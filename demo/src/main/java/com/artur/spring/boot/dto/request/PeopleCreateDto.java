package com.artur.spring.boot.dto.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleCreateDto {

  private String firstName;
  private String lastName;
  private String patronymic;
  private String sex;
  private LocalDate birthday;
}
