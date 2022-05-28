package com.example.demo.controller;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;

    @PostMapping("/players")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Player> save(@RequestBody Player player) {
        return service.save(player);
    }

    @GetMapping(value = "/players")
    private Flux<Player> findAll() {

        Flux<Player> prueba = service.findAll();

        prueba.subscribe(System.out::println);
        /*prueba.toStream()
                .forEach(player -> System.out.println(player.getName()))
        ;*/

        return prueba;
    }
}
