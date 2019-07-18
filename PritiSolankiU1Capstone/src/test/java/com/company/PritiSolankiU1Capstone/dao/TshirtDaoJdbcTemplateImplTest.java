package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Game;
import com.company.PritiSolankiU1Capstone.model.Tshirt;
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
public class TshirtDaoJdbcTemplateImplTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        List<Tshirt> tshirts = tshirtDao.getAllTshirts();
        for (Tshirt it : tshirts) {
            tshirtDao.deleteTshirt(it.gettShirtId());
        }
    }

    @Test
    public void addGetDeleteTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());
        assertEquals(tshirt1,tshirt);

        tshirtDao.deleteTshirt(tshirt.gettShirtId());
        tshirt1 = tshirtDao.getTshirt(tshirt.gettShirtId());
        assertNull(tshirt1);
    }

    @Test
    public void getAllTshirts() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt = new Tshirt();
        tshirt.setSize("Medium");
        tshirt.setColor("Red");
        tshirt.setDescription("Active");
        tshirt.setPrice(new BigDecimal(35));
        tshirt.setQuantity(20);

        tshirtDao.addTshirt(tshirt);

        List<Tshirt> tList = tshirtDao.getAllTshirts();
        assertEquals(2, tList.size());
    }

    @Test
    public void updateTshirt() {

        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        tshirt.setSize("XLarge");
        tshirt.setColor("Light Blue");
        tshirt.setDescription("Active Sportswear");
        tshirt.setPrice(new BigDecimal(45));
        tshirt.setQuantity(5);

        tshirtDao.updateTshirt(tshirt);

        Tshirt tshirt1  = tshirtDao.getTshirt(tshirt.gettShirtId());
        assertEquals(tshirt1,tshirt);
    }

    @Test
    public void getTshirtsByColor() {

        Tshirt tshirt = new Tshirt();

        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = new Tshirt();

        tshirt1.setSize("Medium");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Sportswear");
        tshirt1.setPrice(new BigDecimal(30));
        tshirt1.setQuantity(10);

        tshirtDao.addTshirt(tshirt1);

        List<Tshirt> tList = tshirtDao.getTshirtsByColor(tshirt.getColor());
        assertEquals(1,tList.size());
    }

    @Test
    public void getTshirtsBySize() {

        Tshirt tshirt = new Tshirt();

        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30));
        tshirt.setQuantity(10);

        tshirt = tshirtDao.addTshirt(tshirt);

        Tshirt tshirt1 = new Tshirt();

        tshirt1.setSize("Medium");
        tshirt1.setColor("Red");
        tshirt1.setDescription("Sportswear");
        tshirt1.setPrice(new BigDecimal(30));
        tshirt1.setQuantity(10);

        tshirtDao.addTshirt(tshirt1);

        List<Tshirt> tList = tshirtDao.getTshirtsBySize(tshirt.getSize());
        assertEquals(1,tList.size());

    }
}