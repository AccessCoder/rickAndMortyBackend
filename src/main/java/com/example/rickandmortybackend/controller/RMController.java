package com.example.rickandmortybackend.controller;

import com.example.rickandmortybackend.model.RMCharacter;
import com.example.rickandmortybackend.service.RMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RMController {

    private final RMService service;

    @GetMapping
    public List<RMCharacter> getAllCharacters(){
        return service.getAllCharacters();
    }

    @GetMapping("/alive")
    public List<RMCharacter> getAllLivingCharacters(){
        return service.getAllLivingCharacters();
    }

}
