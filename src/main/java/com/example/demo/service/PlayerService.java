package com.example.demo.service;

import com.example.demo.domain.Player;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerService {
    Mono<Player> save(Player player);

    Mono<Player> delete(Integer id);

    Mono<Player> update(Integer id, Player player);

    Flux<Player> findAll();

    Mono<Player> findById(Integer id);
}
