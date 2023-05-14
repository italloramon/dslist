package com.italloramon.dslist.services;

import com.italloramon.dslist.dto.GameDTO;
import com.italloramon.dslist.dto.GameListDTO;
import com.italloramon.dslist.dto.GameMinDTO;
import com.italloramon.dslist.entities.Game;
import com.italloramon.dslist.entities.GameList;
import com.italloramon.dslist.repositories.GameListRepository;
import com.italloramon.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(gameList -> new GameListDTO(gameList)).toList();
    }
}
