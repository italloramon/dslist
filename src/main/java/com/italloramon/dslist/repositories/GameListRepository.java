package com.italloramon.dslist.repositories;

import com.italloramon.dslist.entities.Game;
import com.italloramon.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
