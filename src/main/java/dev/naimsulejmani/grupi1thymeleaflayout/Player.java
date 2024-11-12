package dev.naimsulejmani.grupi1thymeleaflayout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private String surname;
    private String position;
    private int age;
    private String country;
}
