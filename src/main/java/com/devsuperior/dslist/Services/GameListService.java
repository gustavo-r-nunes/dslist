package com.devsuperior.dslist.Services;

import com.devsuperior.dslist.Entities.GameList;
import com.devsuperior.dslist.Projections.GameMinProjection;
import com.devsuperior.dslist.Repositories.GameListRepository;
import com.devsuperior.dslist.Repositories.GameRepository;
import com.devsuperior.dslist.dto.GameListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){

        List<GameList> result = repository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;

    }

    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> result = gameRepository.searchByList(listId);
        GameMinProjection obj = result.remove(sourceIndex);
        result.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex? sourceIndex: destinationIndex;
        int max = sourceIndex > destinationIndex? sourceIndex: destinationIndex;

        for (int i = min; i <= max; i++){
            repository.updateBelongingPosition(listId, result.get(i).getId(), i);
        }

    }

}
