package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game addGame(Game game);

    Game getGame(int id);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int id);

    List<Game> getGamesByStudio(String studio);

    List<Game> getGamesByErsbRating(String ersbRating);

    List<Game> getGamesByTitle(String title);

}
