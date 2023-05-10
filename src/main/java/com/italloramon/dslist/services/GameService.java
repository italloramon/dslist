package com.italloramon.dslist.services;

import com.italloramon.dslist.dto.GameMinDTO;
import com.italloramon.dslist.entities.Game;
import com.italloramon.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
