package com.devsuperior.dslist.Services;

import com.devsuperior.dslist.Entities.Game;
import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){

        List<Game> result = repository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Optional<Game> result = repository.findById(id);
        return new GameDTO(result.get());
    }

}
