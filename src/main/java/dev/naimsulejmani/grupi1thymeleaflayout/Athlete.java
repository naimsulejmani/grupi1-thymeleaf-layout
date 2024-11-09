package dev.naimsulejmani.grupi1thymeleaflayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Athlete {
    private String name;
    private String surname;
    private String sport;
    private int age;
    private String country;
}
