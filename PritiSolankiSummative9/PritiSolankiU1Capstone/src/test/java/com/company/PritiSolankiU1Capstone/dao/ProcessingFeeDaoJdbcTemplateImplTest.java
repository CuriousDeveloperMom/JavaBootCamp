package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Console;
import com.company.PritiSolankiU1Capstone.model.ProcessingFee;
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
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFeesByProductType() {

        ProcessingFee processingFeeConsole = processingFeeDao.getFeesByProductType("Consoles");
        assertEquals(new BigDecimal("14.99"), processingFeeConsole.getFee());

        ProcessingFee processingFeeGame = processingFeeDao.getFeesByProductType("Games");
        assertEquals(new BigDecimal("1.49"), processingFeeGame.getFee());

        ProcessingFee processingFeeTshirt = processingFeeDao.getFeesByProductType("T-Shirts");
        assertEquals(new BigDecimal("1.98"), processingFeeTshirt.getFee());

    }
}