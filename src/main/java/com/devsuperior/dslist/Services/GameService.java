package com.devsuperior.dslist.Services;

import com.devsuperior.dslist.Entities.Game;
import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){

        List<Game> result = repository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }
}
