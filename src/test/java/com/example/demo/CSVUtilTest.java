package com.example.demo;

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.CsvUtilFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

public class CSVUtilTest {

    @Autowired
    PlayerService service;

    @Test
    void converterData(){
        List<Player> list = CsvUtilFile.getPlayers();
        assert list.size() == 18207;
    }

    @Test
    void stream_filtrarJugadoresMayoresA35(){
        List<Player> list = CsvUtilFile.getPlayers();
        Map<String, List<Player>> listFilter = list.parallelStream()
                .filter(player -> player.age >= 35)
                .map(player -> {
                    player.name = player.name.toUpperCase(Locale.ROOT);
                    return player;
                })
                .flatMap(playerA -> list.parallelStream()
                        .filter(playerB -> playerA.club.equals(playerB.club))
                )
                .distinct()
                .collect(Collectors.groupingBy(Player::getClub));

        assert listFilter.size() == 322;
    }


    @Test
    void reactive_filtrarJugadoresMayoresA35(){
        //List<Player> list = CsvUtilFile.getPlayers();
        //Flux<Player> listFlux = Flux.fromStream(list.parallelStream()).cache();
        Flux<Player> listFlux = service.findAll().
                buffer(100).
                flatMap(x -> Flux.fromStream(x.parallelStream()));
        Mono<Map<String, Collection<Player>>> listFilter = listFlux
                .filter(player -> player.age >= 35)
                .map(player -> {
                    player.name = player.name.toUpperCase(Locale.ROOT);
                    return player;
                })
                .buffer(100)
                .flatMap(playerA -> listFlux
                         .filter(playerB -> playerA.stream()
                                 .anyMatch(a ->  a.club.equals(playerB.club)))
                )
                .distinct()
                .collectMultimap(Player::getClub);

        assert listFilter.block().size() == 322;
    }



}
