package com.italloramon.dslist.services;

import com.italloramon.dslist.dto.GameDTO;
import com.italloramon.dslist.dto.GameListDTO;
import com.italloramon.dslist.dto.GameMinDTO;
import com.italloramon.dslist.entities.Game;
import com.italloramon.dslist.entities.GameList;
import com.italloramon.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(gameList -> new GameListDTO(gameList)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
