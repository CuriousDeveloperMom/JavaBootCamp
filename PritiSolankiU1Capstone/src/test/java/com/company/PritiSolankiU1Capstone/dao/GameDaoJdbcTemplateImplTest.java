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
        game.setPrice(new BigDecimal(49.99));
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
        game.setPrice(new BigDecimal(49.99));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99));
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
        game.setPrice(new BigDecimal(49.99));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99));
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
        game.setPrice(new BigDecimal(49.99));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        Game game1 = new Game();

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(game1);

        List<Game> iList = gameDao.getGamesByStudio(game.getStudio());
        assertEquals(2,iList.size());

    }

    @Test
    public void getGamesByErsbRating() {

        Game game = new Game();

        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        game = gameDao.addGame(game);

        Game invoiceItem1 = new Game();

        game.setTitle("Fortnite1");
        game.setErsbRating("E10+");
        game.setDescription("fortnite1@gmail.com");
        game.setPrice(new BigDecimal(69.99));
        game.setStudio("Bollywood");
        game.setQuantity(15);

        gameDao.addGame(invoiceItem1);

        List<Game> iList = gameDao.getGamesByErsbRating(game.getErsbRating());
        assertEquals(2,iList.size());
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

        game = gameDao.addGame(game);

        Game game1 = new Game();

        game1.setTitle("Fortnite1");
        game1.setErsbRating("E10+");
        game1.setDescription("fortnite1@gmail.com");
        game1.setPrice(new BigDecimal("69.99"));
        game1.setStudio("Bollywood");
        game1.setQuantity(15);

        game1 = gameDao.addGame(game1);

        List<Game> iList = gameDao.getGamesByTitle(game.getTitle());


        System.out.println(iList.size());

        assertEquals(1,iList.size());
    }
}