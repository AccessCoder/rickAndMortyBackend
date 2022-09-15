package com.example.rickandmortybackend.service;

import com.example.rickandmortybackend.model.RMCharacter;
import com.example.rickandmortybackend.model.RMResponseElement;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class RMService {

    WebClient client = WebClient.create("https://rickandmortyapi.com/api");

    public List<RMCharacter> getAllCharacters() {
        return client.get()
                .uri("/character")
                .retrieve()
                .toEntity(RMResponseElement.class)
                .block()
                .getBody()
                .getResults();
    }

    public List<RMCharacter> getAllLivingCharacters() {
       List<RMCharacter> aliveList = new ArrayList<>();
        List<RMCharacter> characters =
                client.get()
                .uri("/character")
                .retrieve()
                .toEntity(RMResponseElement.class)
                .block()
                .getBody()
                .getResults();

        for (RMCharacter character : characters) {
            if (character.getStatus().equals("Alive")){
                aliveList.add(character);
            }
        }
        return aliveList;
    }

}
