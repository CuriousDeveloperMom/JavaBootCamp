package com.company.PritiSolankiU1Capstone.controller;
import com.company.PritiSolankiU1Capstone.service.ServiceLayer;
import com.company.PritiSolankiU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameInventoryController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return serviceLayer.findAllGames();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        return serviceLayer.saveGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int gameId) {
        GameViewModel gamesViewModel = serviceLayer.findGamebyId(gameId);
        if (gamesViewModel == null)
            throw new IllegalArgumentException("Games does not exist for id " + gameId);
        return gamesViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        serviceLayer.removeGame(gameId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGames(@PathVariable("id") int gameId, @RequestBody @Valid GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == 0)
            gameViewModel.setGameId(gameId);
        if (gameId != gameViewModel.getGameId()) {
            throw new IllegalArgumentException("Game ID provided not available.");
        }
        serviceLayer.updateGame(gameViewModel);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        List<GameViewModel> gameViewModelList = serviceLayer.findGamebyStudio(studio);
        if (gameViewModelList != null && gameViewModelList.size() == 0)
            throw new IllegalArgumentException("Game is not available for " + studio);
        return gameViewModelList;
    }

    @GetMapping("/ersb/{ersb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByErsb(@PathVariable("ersb") String ersbRating) {
        List<GameViewModel> gameViewModelList = serviceLayer.findGamebyErsbRating(ersbRating);
        if (gameViewModelList != null && gameViewModelList.size() == 0)
            throw new IllegalArgumentException("Game is not available for " + ersbRating);
        return gameViewModelList;
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title) {
        List<GameViewModel> games = serviceLayer.findGamebyTitle(title);
        if (games != null && games.size() == 0)
            throw new IllegalArgumentException("Game is not available for " + title);
        return games;
    }
}
