package com.company.PritiSolankiU1Capstone.service;

import com.company.PritiSolankiU1Capstone.dao.*;
import com.company.PritiSolankiU1Capstone.model.*;
import com.company.PritiSolankiU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    TshirtDao tshirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, TshirtDao tshirtDao,
                        ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.tshirtDao = tshirtDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }

    //#########################################CONSOLE METHODS##########################################################

    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        console = consoleDao.addConsole(console);

        consoleViewModel.setConsoleId(console.getConsoleId());
        return consoleViewModel;
    }

    public ConsoleViewModel findConsolebyId(int id) {
        Console console = consoleDao.getConsole(id);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public List<ConsoleViewModel> findAllConsoles() {

        List<Console> consoleList = consoleDao.getAllConsoles();
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();
        for (Console console : consoleList) {
            ConsoleViewModel consoleViewModel = buildConsoleViewModel(console);
            consoleViewModelList.add(consoleViewModel);
        }
        return consoleViewModelList;
    }

    @Transactional
    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Console console = new Console();

        console.setConsoleId(consoleViewModel.getConsoleId());
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        consoleDao.updateConsole(console);
    }

    @Transactional
    public void removeConsole(int id) {
        consoleDao.deleteConsole(id);
    }

    public List<ConsoleViewModel> findConsolebyManufacturer(String manufacturer) {

        List<Console> consoleList = consoleDao.getConsolesByManufacturer(manufacturer);
        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();

        for (Console console : consoleList) {
            ConsoleViewModel consoleViewModel = buildConsoleViewModel(console);
            consoleViewModelList.add(consoleViewModel);
        }
        return consoleViewModelList;
    }

    //#############################################game Methods######################################################

    @Transactional
    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);

        gameViewModel.setGameId(game.getGameId());
        return gameViewModel;
    }

    public GameViewModel findGamebyId(int id) {
        Game game = gameDao.getGame(id);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public List<GameViewModel> findAllGames() {

        List<Game> gameList = gameDao.getAllGames();
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for (Game game : gameList) {
            GameViewModel gameViewModel = buildGameViewModel(game);
            gameViewModelList.add(gameViewModel);
        }
        return gameViewModelList;
    }

    @Transactional
    public void updateGame(GameViewModel gameViewModel) {
        Game game = new Game();

        game.setGameId(gameViewModel.getGameId());
        game.setTitle(gameViewModel.getTitle());
        game.setErsbRating(gameViewModel.getErsbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());

        gameDao.updateGame(game);
    }

    @Transactional
    public void removeGame(int id) {

        gameDao.deleteGame(id);
    }

    //Search for Games by Title

    public List<GameViewModel> findGamebyTitle(String title) {

        List<Game> gameList = gameDao.getGamesByTitle(title);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for (Game game : gameList) {
            GameViewModel gameViewModel = buildGameViewModel(game);
            gameViewModelList.add(gameViewModel);
        }
        return gameViewModelList;
    }

    //Search for Games by Studio

    public List<GameViewModel> findGamebyStudio(String studio) {

        List<Game> gameList = gameDao.getGamesByStudio(studio);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for (Game game : gameList) {
            GameViewModel gameViewModel = buildGameViewModel(game);
            gameViewModelList.add(gameViewModel);
        }
        return gameViewModelList;
    }

    //Search for Games by ESRB Rating

    public List<GameViewModel> findGamebyErsbRating(String ersbrating) {

        List<Game> gameList = gameDao.getGamesByErsbRating(ersbrating);
        List<GameViewModel> gameViewModelList = new ArrayList<>();

        for (Game game : gameList) {
            GameViewModel gameViewModel = buildGameViewModel(game);
            gameViewModelList.add(gameViewModel);
        }
        return gameViewModelList;
    }

    //#######################################TShirt Methods#############################################################

    @Transactional
    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());

        tshirtViewModel.settShirtId(tshirt.gettShirtId());
        return tshirtViewModel;
    }

    public TshirtViewModel findTshirtbyId(int id) {
        Tshirt tshirt = tshirtDao.getTshirt(id);
        if (tshirt == null)
            return null;
        else
            return buildTshirtViewModel(tshirt);
    }

    public List<TshirtViewModel> findAllTshirts() {

        List<Tshirt> tshirtList = tshirtDao.getAllTshirts();
        List<TshirtViewModel> tshirtViewModelList = new ArrayList<>();
        for (Tshirt tshirt : tshirtList) {
            TshirtViewModel tshirtViewModel = buildTshirtViewModel(tshirt);
            tshirtViewModelList.add(tshirtViewModel);
        }
        return tshirtViewModelList;
    }

    @Transactional
    public void updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();

        tshirt.settShirtId(tshirtViewModel.gettShirtId());
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());

        tshirtDao.updateTshirt(tshirt);
    }

    @Transactional
    public void removeTshirt(int id) {

        tshirtDao.deleteTshirt(id);

    }

    public List<TshirtViewModel> findTshirtbySize(String size) {

        List<Tshirt> tshirtList = tshirtDao.getTshirtsBySize(size);
        List<TshirtViewModel> tshirtViewModelList = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            TshirtViewModel tshirtViewModel = buildTshirtViewModel(tshirt);
            tshirtViewModelList.add(tshirtViewModel);
        }

        return tshirtViewModelList;
    }

    public List<TshirtViewModel> findTshirtbyColor(String color) {

        List<Tshirt> tshirtList = tshirtDao.getTshirtsByColor(color);
        List<TshirtViewModel> tshirtViewModelList = new ArrayList<>();

        for (Tshirt tshirt : tshirtList) {
            TshirtViewModel tshirtViewModel = buildTshirtViewModel(tshirt);
            tshirtViewModelList.add(tshirtViewModel);
        }

        return tshirtViewModelList;
    }

    //########################################## INVOICE METHODS ######################################################

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceInputViewModel invoiceInputViewModel) {

        //Order quantity must be greater than zero.
        //Order quantity must be less than or equal to the number of items on hand in inventory.
        //Order must contain a valid state code.

        Invoice invoice = new Invoice();
        invoice.setName(invoiceInputViewModel.getName());
        invoice.setStreet(invoiceInputViewModel.getStreet());
        invoice.setCity(invoiceInputViewModel.getCity());
        invoice.setState(invoiceInputViewModel.getState());
        invoice.setZipcode(invoiceInputViewModel.getZipcode());
        invoice.setItemType(invoiceInputViewModel.getItemType());
        invoice.setItemId(invoiceInputViewModel.getItemId());
        invoice.setQuantity(invoiceInputViewModel.getQuantity());

        // For Business Logic Calculations

        BigDecimal unitPrice;
        BigDecimal subtotal;
        BigDecimal salesTax;
        BigDecimal processingFee;
        BigDecimal total;
////////////////
        //if (invoice != null){
            if (invoice.getItemType().equals("Consoles")) {

                Console console = consoleDao.getConsole(invoice.getItemId());
                unitPrice = console.getPrice();

                if (invoice.getQuantity() > console.getQuantity()) {
                    throw new IllegalArgumentException("There are not enough items in inventory");
                } else {
                    console.setQuantity(console.getQuantity() - invoice.getQuantity());
                    consoleDao.updateConsole(console);
                }
            } else if (invoice.getItemType().equals("Games")) {

                Game game = gameDao.getGame(invoice.getItemId());
                unitPrice = game.getPrice();

                if (invoice.getQuantity() > game.getQuantity()) {
                    throw new IllegalArgumentException("There are not enough items in inventory");
                } else {
                    game.setQuantity(game.getQuantity() - invoice.getQuantity());
                    gameDao.updateGame(game);
                }
            } else if (invoice.getItemType().equals("T-Shirts")) {

                Tshirt tshirt = tshirtDao.getTshirt(invoice.getItemId());
                unitPrice = tshirt.getPrice();

                if (invoice.getQuantity() > tshirt.getQuantity()) {
                    throw new IllegalArgumentException("There are not enough items in inventory");
                } else {
                    tshirt.setQuantity(tshirt.getQuantity() - invoice.getQuantity());
                    tshirtDao.updateTshirt(tshirt);
                }
            } else {
                throw new IllegalArgumentException("Invalid Product type is entered.");
            }
        subtotal = unitPrice.multiply(BigDecimal.valueOf(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);

        // Formula tax = rate * subtotal

        salesTax = salesTaxRateDao.getRateByState(invoice.getState()).getRate().multiply(subtotal).setScale(2, RoundingMode.HALF_UP);

        processingFee = processingFeeDao.getFeesByProductType(invoice.getItemType()).getFee();

        if (invoice.getQuantity() > 10) {
            processingFee = processingFee.add(new BigDecimal(15.49)).setScale(2, RoundingMode.HALF_UP);
        }

        total = subtotal.add(salesTax).add(processingFee).setScale(2, RoundingMode.HALF_UP);

        invoice.setUnitPrice(unitPrice);
        invoice.setSubtotal(subtotal);
        invoice.setTax(salesTax);
        invoice.setProcessingFee(processingFee);
        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);

        //invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        return buildInvoiceViewModel(invoice);
    }

    public InvoiceViewModel findInvoicebyId(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    //###########################################################################################################


    // Helper Methods

    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setConsoleId(console.getConsoleId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setGameId(game.getGameId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setErsbRating(game.getErsbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());

        return gameViewModel;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {

        TshirtViewModel tshirtViewModel = new TshirtViewModel();
        tshirtViewModel.settShirtId(tshirt.gettShirtId());
        tshirtViewModel.setSize(tshirt.getSize());
        tshirtViewModel.setColor(tshirt.getColor());
        tshirtViewModel.setDescription(tshirt.getDescription());
        tshirtViewModel.setPrice(tshirt.getPrice());
        tshirtViewModel.setQuantity(tshirt.getQuantity());

        return tshirtViewModel;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipcode(invoice.getZipcode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());

        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubtotal(invoice.getSubtotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

}
    /*
    public String validate(InvoiceInputViewModel invoiceInputViewModel){

        String message = "";

        SalesTaxRate salesTaxRate = salesTaxRateDao.getRateByState(invoiceInputViewModel.getState());

        //Check for State Validation

        if (salesTaxRate == null)
            message = "Invalid State code";

        ProcessingFee processingFee = processingFeeDao.getFeesByProductType(invoiceInputViewModel.getItemType());

        //Check for Product_type Validation

        if (processingFee != null) {
            if (!processingFee.getProductType().equals("Consoles")) {
                message = "Invalid Item";
            }
            if (processingFee.getProductType().equals("T-Shirts")) {
                message = "Invalid Item";
            }
            if (processingFee.getProductType().equals("Games")) {
                message = "Invalid Item";
            }
        }
        else
            message = "Invalid Item";



        //if (invoiceInputViewModel.getState().equals(salesTaxRateDao.getRateByState(invoiceInputViewModel.getState());

       /* if (invoiceInputViewModel.getState().equals(salesTaxRateDao.getRateByState(invoiceInputViewModel.getState()){

            String type = invoiceInputViewModel.getItemType();
            int quantity = invoiceInputViewModel.getQuantity();

            if (type.equals("Consoles") && (quantity > 0) && (quantity <= consoleDao.))


            }*/

            //if (invoiceInputViewModel.getQuantity() > 0 && invoiceInputViewModel.getQuantity() )











