package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        List<Game> games = gameDao.getAllGames();
        for (Game it : games) {
            gameDao.deleteGame(it.getGameId());
        }
    }
    @After
    public void tearDown() throws Exception {
        List<Game> gamesList = gameDao.getAllGames();
        gamesList.stream()
                .forEach(game->{
                    gameDao.deleteGame(game.getGameId());
                });
    }

    @Test
    public void addGetandDeleteGame() {

        Game game = new Game();
        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());
        assertEquals(game1, game);

        gameDao.deleteGame(game.getGameId());

        game1 = gameDao.getGame(game.getGameId());
        assertNull(game1);
    }

    @Test
    public void getAllGames() {

        Game game = new Game();
        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        gameDao.addGame(game);

        List<Game> gList = gameDao.getAllGames();
        assertEquals(2, gList.size());

    }

    @Test
    public void updateGame() {

        Game game = new Game();
        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99).setScale(2, HALF_UP));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.updateGame(game);

        Game game1  = gameDao.getGame(game.getGameId());
        assertEquals(game1,game);
    }

    @Test
    public void getGamesByStudio() {

        Game game = new Game();

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99).setScale(2, HALF_UP));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(game);

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99).setScale(2, HALF_UP));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(game);

        List<Game> gList = gameDao.getGamesByStudio("Bollywood");
        assertEquals(2,gList.size());

        gList = gameDao.getGamesByStudio("Hollywood");
        assertEquals(1,gList.size());

        gList = gameDao.getGamesByStudio("Opera");
        assertEquals(0,gList.size());
    }

    @Test
    public void getGamesByErsbRating() {

        Game game = new Game();

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        gameDao.addGame(game);

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99).setScale(2, HALF_UP));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(game);

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        gameDao.addGame(game);

        List<Game> gList = gameDao.getGamesByErsbRating("EC");
        assertEquals(2,gList.size());

        gList = gameDao.getGamesByErsbRating("E10+");
        assertEquals(1,gList.size());

        gList = gameDao.getGamesByErsbRating("A");
        assertEquals(0,gList.size());
    }

    @Test
    public void getGamesByTitle() {

        Game game = new Game();

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        gameDao.addGame(game);

        game.setTitle("Fortnite");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(game);

        game.setTitle("Mario");
        game.setErsbRating("EC");
        game.setDescription("mario@gmail.com");
        game.setPrice(new BigDecimal("69.99"));
        game.setStudio("Hollywood");
        game.setQuantity(15);

        gameDao.addGame(game);


        List<Game> gList = gameDao.getGamesByTitle("Fortnite");
        assertEquals(2,gList.size());

        gList = gameDao.getGamesByTitle("Mario");
        assertEquals(1,gList.size());

        gList = gameDao.getGamesByTitle("Pokemon");
        assertEquals(0,gList.size());
    }
}