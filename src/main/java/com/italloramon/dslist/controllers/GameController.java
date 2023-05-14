package com.italloramon.dslist.controllers;

import com.italloramon.dslist.dto.GameDTO;
import com.italloramon.dslist.dto.GameMinDTO;
import com.italloramon.dslist.entities.Game;
import com.italloramon.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }
    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
