package com.devsuperior.dslist.Controllers;

import com.devsuperior.dslist.Entities.Game;
import com.devsuperior.dslist.Services.GameService;
import com.devsuperior.dslist.dto.GameMinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        return service.findAll();
    }

}
