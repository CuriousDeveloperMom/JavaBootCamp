package com.company.PritiSolankiU1Capstone.service;

import com.company.PritiSolankiU1Capstone.dao.*;
import com.company.PritiSolankiU1Capstone.model.*;
import com.company.PritiSolankiU1Capstone.viewmodel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    ServiceLayer serviceLayer;


    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpTshirtDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();

        serviceLayer = new ServiceLayer(consoleDao, gameDao, invoiceDao, tshirtDao, processingFeeDao, salesTaxRateDao);
    }

    @After
    public void tearDown() throws Exception {
    }

    private void setUpConsoleDaoMock() {

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("XBox");
        console.setManufacturer("Ninetendo");
        console.setMemoryAmount("64");
        console.setProcessor("Intel");
        console.setPrice(new BigDecimal("49.00").setScale(2, RoundingMode.HALF_UP));
        console.setQuantity(15);

        Console console1 = new Console();

        console1.setModel("XBox");
        console1.setManufacturer("Ninetendo");
        console1.setMemoryAmount("64");
        console1.setProcessor("Intel");
        console1.setPrice(new BigDecimal("49.00").setScale(2, RoundingMode.HALF_UP));;
        console1.setQuantity(15);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).getConsolesByManufacturer(console.getManufacturer());
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Fortnite");
        game.setErsbRating("EC");
        game.setDescription("fortnite@gmail.com");
        game.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        game.setStudio("Hollywood");
        game.setQuantity(12);

        Game game1 = new Game();
        game1.setTitle("Fortnite");
        game1.setErsbRating("EC");
        game1.setDescription("fortnite@gmail.com");
        game1.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        game1.setStudio("Hollywood");
        game1.setQuantity(12);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGamesByTitle(game.getTitle());
        doReturn(gameList).when(gameDao).getGamesByErsbRating(game.getErsbRating());
        doReturn(gameList).when(gameDao).getGamesByStudio(game.getStudio());
    }

    private void setUpTshirtDaoMock() {

        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();
        tshirt.settShirtId(1);
        tshirt.setSize("Large");
        tshirt.setColor("Blue");
        tshirt.setDescription("Sportswear");
        tshirt.setPrice(new BigDecimal(30.00).setScale(2, RoundingMode.HALF_UP));
        tshirt.setQuantity(10);

        Tshirt tshirt1 = new Tshirt();

        tshirt1.setSize("Large");
        tshirt1.setColor("Blue");
        tshirt1.setDescription("Sportswear");
        tshirt1.setPrice(new BigDecimal(30.00).setScale(2, RoundingMode.HALF_UP));
        tshirt1.setQuantity(10);


        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(tshirt);

        doReturn(tshirt).when(tshirtDao).addTshirt(tshirt1);
        doReturn(tshirt).when(tshirtDao).getTshirt(1);
        doReturn(tshirtList).when(tshirtDao).getAllTshirts();
        doReturn(tshirtList).when(tshirtDao).getTshirtsByColor(tshirt.getColor());
        doReturn(tshirtList).when(tshirtDao).getTshirtsBySize(tshirt.getSize());
    }

    private void setUpInvoiceDaoMock() {

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(1);
        invoice.setName("John Kapra");
        invoice.setStreet("Glory drive");
        invoice.setCity("Clifton");
        invoice.setState("NJ");
        invoice.setZipcode("07087");
        invoice.setItemType("Consoles");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("49.00").setScale(2, RoundingMode.HALF_UP));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("98.00").setScale(2, RoundingMode.HALF_UP));
        invoice.setTax(new BigDecimal("5.88").setScale(2, RoundingMode.HALF_UP));
        invoice.setProcessingFee(new BigDecimal("3.00").setScale(2, RoundingMode.HALF_UP));
        invoice.setTotal(new BigDecimal("106.88").setScale(2, RoundingMode.HALF_UP));

        Invoice invoice1 = new Invoice();

        invoice1.setName("John Kapra");
        invoice1.setStreet("Glory drive");
        invoice1.setCity("Clifton");
        invoice1.setState("NJ");
        invoice1.setZipcode("07087");
        invoice1.setItemType("Consoles");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("49.00").setScale(2, RoundingMode.HALF_UP));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("98.00").setScale(2, RoundingMode.HALF_UP));
        invoice1.setTax(new BigDecimal("5.88").setScale(2, RoundingMode.HALF_UP));
        invoice1.setProcessingFee(new BigDecimal("3.00").setScale(2, RoundingMode.HALF_UP));
        invoice1.setTotal(new BigDecimal("106.88").setScale(2, RoundingMode.HALF_UP));


        //List<Invoice> invoiceList = new ArrayList<>();
        //invoiceList.add(invoice);
        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        //doReturn(invoice).when(invoiceDao).getInvoice(1);
        //doReturn(invoiceList).when(invoiceDao).getAllInvoices();
    }

    private void setUpProcessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Consoles");
        processingFee.setFee(new BigDecimal(3.00).setScale(2, RoundingMode.HALF_UP));

        doReturn(processingFee).when(processingFeeDao).getFeesByProductType("Consoles");

    }
    private void setUpSalesTaxRateDaoMock() {

        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NJ");
        salesTaxRate.setRate(new BigDecimal(0.06).setScale(2, RoundingMode.HALF_UP));
        doReturn(salesTaxRate).when(salesTaxRateDao).getRateByState("NJ");
    }

    //##################################### Console MOCK TESTS #################################################

    @Test
    public void findAllConsoles() {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setModel("XBox");
        consoleViewModel.setManufacturer("Ninetendo");
        consoleViewModel.setMemoryAmount("64");
        consoleViewModel.setProcessor("Intel");
        consoleViewModel.setPrice(new BigDecimal(49.00).setScale(2, RoundingMode.HALF_UP));
        consoleViewModel.setQuantity(15);

        List<ConsoleViewModel> consoleViewModelList = serviceLayer.findAllConsoles();
        assertEquals(consoleViewModelList.size(),1);
    }

    @Test
    public void saveGetConsole(){

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setModel("XBox");
        consoleViewModel.setManufacturer("Ninetendo");
        consoleViewModel.setMemoryAmount("64");
        consoleViewModel.setProcessor("Intel");
        consoleViewModel.setPrice(new BigDecimal(49.00).setScale(2, RoundingMode.HALF_UP));
        consoleViewModel.setQuantity(15);

        consoleViewModel = serviceLayer.saveConsole(consoleViewModel);
        ConsoleViewModel fromService = serviceLayer.findConsolebyId(consoleViewModel.getConsoleId());
        assertEquals(consoleViewModel, fromService);
    }

    @Test
    public void findConsolebyManufacturer() {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();

        consoleViewModel.setModel("XBox");
        consoleViewModel.setManufacturer("Ninetendo");
        consoleViewModel.setMemoryAmount("64");
        consoleViewModel.setProcessor("Intel");
        consoleViewModel.setPrice(new BigDecimal(49.00).setScale(2, RoundingMode.HALF_UP));
        consoleViewModel.setQuantity(15);

        consoleViewModel = serviceLayer.saveConsole(consoleViewModel);
        List<ConsoleViewModel> consoleViewModels = serviceLayer.findConsolebyManufacturer("Ninetendo");
        assertEquals(consoleViewModels.size(),1);
        assertEquals(consoleViewModels.get(0), consoleViewModel);
    }




    //####################################### Game MOCK TESTS ##################################################

    @Test
    public void saveGetGame() {

        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Fortnite");
        gameViewModel.setErsbRating("EC");
        gameViewModel.setDescription("fortnite@gmail.com");
        gameViewModel.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        gameViewModel.setStudio("Hollywood");
        gameViewModel.setQuantity(12);

        gameViewModel = serviceLayer.saveGame(gameViewModel);
        GameViewModel fromService = serviceLayer.findGamebyId(gameViewModel.getGameId());
        assertEquals(gameViewModel, fromService);
    }

    @Test
    public void findAllGames() {

        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setGameId(1);
        gameViewModel.setTitle("Fortnite");
        gameViewModel.setErsbRating("EC");
        gameViewModel.setDescription("fortnite@gmail.com");
        gameViewModel.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        gameViewModel.setStudio("Hollywood");
        gameViewModel.setQuantity(12);

        List<GameViewModel> gameViewModelList = serviceLayer.findAllGames();
        assertEquals(gameViewModelList.size(),1);
    }

    @Test
    public void findGamebyStudio() {

        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Fortnite");
        gameViewModel.setErsbRating("EC");
        gameViewModel.setDescription("fortnite@gmail.com");
        gameViewModel.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        gameViewModel.setStudio("Hollywood");
        gameViewModel.setQuantity(12);

        gameViewModel = serviceLayer.saveGame(gameViewModel);
        List<GameViewModel> gameViewModelList = serviceLayer.findGamebyStudio("Hollywood");
        assertEquals(gameViewModelList.size(),1);
        assertEquals(gameViewModelList.get(0), gameViewModel);
    }
    @Test
    public void findGamebyTitle() {

        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Fortnite");
        gameViewModel.setErsbRating("EC");
        gameViewModel.setDescription("fortnite@gmail.com");
        gameViewModel.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        gameViewModel.setStudio("Hollywood");
        gameViewModel.setQuantity(12);

        gameViewModel = serviceLayer.saveGame(gameViewModel);
        List<GameViewModel> gameViewModelList = serviceLayer.findGamebyTitle("Fortnite");
        assertEquals(gameViewModelList.size(),1);
        assertEquals(gameViewModelList.get(0), gameViewModel);
    }

    @Test
    public void findGamebyErsbRating() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Fortnite");
        gameViewModel.setErsbRating("EC");
        gameViewModel.setDescription("fortnite@gmail.com");
        gameViewModel.setPrice(new BigDecimal(49.99).setScale(2, RoundingMode.HALF_UP));
        gameViewModel.setStudio("Hollywood");
        gameViewModel.setQuantity(12);

        gameViewModel = serviceLayer.saveGame(gameViewModel);
        List<GameViewModel> gameViewModelList = serviceLayer.findGamebyErsbRating("EC");
        assertEquals(gameViewModelList.size(),1);
        assertEquals(gameViewModelList.get(0), gameViewModel);
    }


    //####################################### T-Shirt MOCK TESTS ##################################################
    @Test
    public void saveGetTshirt() {

        TshirtViewModel tshirtViewModel = new TshirtViewModel();
        tshirtViewModel.setSize("Large");
        tshirtViewModel.setColor("Blue");
        tshirtViewModel.setDescription("Sportswear");
        tshirtViewModel.setPrice(new BigDecimal(30.00).setScale(2, RoundingMode.HALF_UP));
        tshirtViewModel.setQuantity(10);

        tshirtViewModel = serviceLayer.saveTshirt(tshirtViewModel);
        TshirtViewModel fromService = serviceLayer.findTshirtbyId(tshirtViewModel.gettShirtId());
        assertEquals(tshirtViewModel, fromService);

    }

    @Test
    public void findAllTshirts() {

            TshirtViewModel tshirtViewModel = new TshirtViewModel();

            tshirtViewModel.settShirtId(1);
            tshirtViewModel.setSize("Large");
            tshirtViewModel.setColor("Blue");
            tshirtViewModel.setDescription("Sportswear");
            tshirtViewModel.setPrice(new BigDecimal(30).setScale(2, RoundingMode.HALF_UP));
            tshirtViewModel.setQuantity(10);

            List<TshirtViewModel> tshirtViewModelList = serviceLayer.findAllTshirts();
            assertEquals(tshirtViewModelList.size(),1);
    }
    @Test
    public void findTshirtbyColor() {

        TshirtViewModel tshirtViewModel = new TshirtViewModel();

        tshirtViewModel.setSize("Large");
        tshirtViewModel.setColor("Blue");
        tshirtViewModel.setDescription("Sportswear");
        tshirtViewModel.setPrice(new BigDecimal(30).setScale(2, RoundingMode.HALF_UP));
        tshirtViewModel.setQuantity(10);

        tshirtViewModel = serviceLayer.saveTshirt(tshirtViewModel);
            List<TshirtViewModel> tshirtViewModelList = serviceLayer.findTshirtbyColor("Blue");
            assertEquals(tshirtViewModelList.size(),1);
            assertEquals(tshirtViewModelList.get(0), tshirtViewModel);
    }
    @Test
    public void findTshirtbySize() {

        TshirtViewModel tshirtViewModel = new TshirtViewModel();

        tshirtViewModel.setSize("Large");
        tshirtViewModel.setColor("Blue");
        tshirtViewModel.setDescription("Sportswear");
        tshirtViewModel.setPrice(new BigDecimal(30.0).setScale(2, RoundingMode.HALF_UP));
        tshirtViewModel.setQuantity(10);

        tshirtViewModel = serviceLayer.saveTshirt(tshirtViewModel);
        List<TshirtViewModel> tshirtViewModelList = serviceLayer.findTshirtbySize("Large");
        assertEquals(tshirtViewModelList.size(),1);
        assertEquals(tshirtViewModelList.get(0), tshirtViewModel);

    }
    //####################################### Invoice MOCK TESTS ##################################################

    @Test
    public void saveInvoice() {
        //   InvoiceInputViewModel
        InvoiceInputViewModel invoiceInputViewModel = new InvoiceInputViewModel();
        invoiceInputViewModel.setName("John Kapra");
        invoiceInputViewModel.setStreet("Glory drive");
        invoiceInputViewModel.setCity("Clifton");
        invoiceInputViewModel.setState("NJ");
        invoiceInputViewModel.setZipcode("07087");
        invoiceInputViewModel.setItemType("Consoles");
        invoiceInputViewModel.setItemId(1);
        invoiceInputViewModel.setQuantity(2);

        //Service Layer
        InvoiceViewModel fromService = serviceLayer.saveInvoice(invoiceInputViewModel);

        //    InvoiceViewModel

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(1);
        invoiceViewModel.setName("John Kapra");
        invoiceViewModel.setStreet("Glory drive");
        invoiceViewModel.setCity("Clifton");
        invoiceViewModel.setState("NJ");
        invoiceViewModel.setZipcode("07087");
        invoiceViewModel.setItemType("Consoles");
        invoiceViewModel.setItemId(1);
        invoiceViewModel.setUnitPrice(new BigDecimal("49.00").setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setQuantity(2);
        invoiceViewModel.setSubtotal(new BigDecimal("98.00").setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setTax(new BigDecimal("5.88").setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setProcessingFee(new BigDecimal("3.00").setScale(2, RoundingMode.HALF_UP));
        invoiceViewModel.setTotal(new BigDecimal("106.88").setScale(2, RoundingMode.HALF_UP));

        assertEquals(invoiceViewModel,fromService);

    }
}