package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Game;
import com.company.PritiSolankiU1Capstone.model.SalesTaxRate;
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
public class SalesTaxRateDaoJdbcTemplateImplTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRateByState() {

        SalesTaxRate salesTaxRateFL = salesTaxRateDao.getRateByState("FL");
        assertEquals(new BigDecimal("0.06"), salesTaxRateFL.getRate());

        SalesTaxRate salesTaxRateGA = salesTaxRateDao.getRateByState("GA");
        assertEquals(new BigDecimal("0.07"), salesTaxRateGA.getRate());

        SalesTaxRate salesTaxRateKY = salesTaxRateDao.getRateByState("KY");
        assertEquals(new BigDecimal("0.04"), salesTaxRateKY.getRate());

        SalesTaxRate salesTaxRateNY = salesTaxRateDao.getRateByState("NY");
        assertEquals(new BigDecimal("0.06"), salesTaxRateNY.getRate());

    }
}