package com.example.demo.repository;

import com.example.demo.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<Player, Integer> {

}