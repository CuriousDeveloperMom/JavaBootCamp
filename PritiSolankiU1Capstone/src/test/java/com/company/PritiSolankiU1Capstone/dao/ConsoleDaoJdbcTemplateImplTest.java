package com.company.PritiSolankiU1Capstone.dao;

import com.company.PritiSolankiU1Capstone.model.Console;
import com.company.PritiSolankiU1Capstone.model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        List<Console> consoles = consoleDao.getAllConsoles();
        for (Console it : consoles) {
            consoleDao.deleteConsole(it.getConsoleId());
        }
    }

    @After
    public void tearDown() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream()
                .forEach(console -> {
                    consoleDao.deleteConsole(console.getConsoleId());
                });
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("XBox");
        console.setManufacturer("Ninetendo");
        console.setMemoryAmount("xbox@gmail.com");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("49").setScale(2,HALF_UP));
        console.setQuantity(15);

        console = consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console1,console);

       // List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        //assertEquals(1, invoiceList.size());

        consoleDao.deleteConsole(console.getConsoleId());
        console1 = consoleDao.getConsole(console.getConsoleId());
        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {

        Console console = new Console();
        console.setModel("XBox");
        console.setManufacturer("Ninetendo");
        console.setMemoryAmount("xbox@gmail.com");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        console.setQuantity(15);

        console = consoleDao.addConsole(console);

        console.setModel("XBox1");
        console.setManufacturer("Ninetendo3ds");
        console.setMemoryAmount("xbox1@gmail.com");
        console.setProcessor("Intel5");
        console.setPrice(new BigDecimal(59.99).setScale(2, HALF_UP));
        console.setQuantity(10);

        consoleDao.addConsole(console);

        List<Console> cList = consoleDao.getAllConsoles();
        assertEquals(2,cList.size());
    }

    @Test
    public void updateConsole() {

        Console console = new Console();
        console.setModel("XBox");
        console.setManufacturer("Ninetendo");
        console.setMemoryAmount("xbox@gmail.com");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("49.99").setScale(2, HALF_UP));
        console.setQuantity(15);

        console = consoleDao.addConsole(console);

        console.setModel("XBox1");
        console.setManufacturer("Ninetendo3ds");
        console.setMemoryAmount("xbox1@gmail.com");
        console.setProcessor("Intel5");
        console.setPrice(new BigDecimal("59.99").setScale(2, HALF_UP));
        console.setQuantity(10);

        consoleDao.updateConsole(console);

        Console console1  = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console1,console);
    }

    @Test
    public void getConsolesByManufacturer() {

        Console console = new Console();
        console.setModel("XBox");
        console.setManufacturer("Ninetendo");
        console.setMemoryAmount("xbox@gmail.com");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        console.setQuantity(15);

        console = consoleDao.addConsole(console);

        Console console1 = new Console();
        console1.setModel("XBox");
        console1.setManufacturer("Ninetendo");
        console1.setMemoryAmount("xbox@gmail.com");
        console1.setProcessor("Intel");
        console1.setPrice(new BigDecimal(49.99).setScale(2, HALF_UP));
        console1.setQuantity(15);

        console1 = consoleDao.addConsole(console1);

        List<Console> cList = consoleDao.getConsolesByManufacturer(console.getManufacturer());
        //assertEquals(2,cList.size());
        assertEquals(cList.size(), 2);
        assertEquals(cList.get(0), console);

    }
}