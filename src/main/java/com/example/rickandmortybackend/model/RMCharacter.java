package com.example.rickandmortybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RMCharacter {


    private int id;
    private String name;
    private String status;
    private String species;

}
