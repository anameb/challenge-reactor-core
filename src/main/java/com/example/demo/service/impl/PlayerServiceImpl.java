package com.example.demo.service.impl;

import com.example.demo.domain.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Mono<Player> save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Mono<Player> delete(Integer id) {
        return playerRepository.findById(id)
                .flatMap(player -> playerRepository.deleteById(player.getId()).thenReturn(player));
    }

    @Override
    public Mono<Player> update(Integer id, Player player) {
        return this.playerRepository.findById(id)
                .flatMap(player1 -> {
                    player.setId(id);
                    return save(player);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Mono<Player> findById(Integer id) {
        return playerRepository.findById(id);
    }
}
