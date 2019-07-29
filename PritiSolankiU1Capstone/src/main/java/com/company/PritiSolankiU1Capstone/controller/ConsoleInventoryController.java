package com.company.PritiSolankiU1Capstone.controller;

import com.company.PritiSolankiU1Capstone.service.ServiceLayer;
import com.company.PritiSolankiU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsoleInventoryController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllconsoles() {
        return serviceLayer.findAllConsoles();
    }

   /* @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console) {
        return serviceLayer.saveConsole(console);
    }*/

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
        ConsoleViewModel consoleViewModel = serviceLayer.findConsolebyId(consoleId);
        if (consoleViewModel == null)
            throw new IllegalArgumentException("Console does not exist for id " + consoleId);
        return consoleViewModel;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {
        serviceLayer.removeConsole(consoleId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(consoleId);
        if (consoleId != consoleViewModel.getConsoleId()) {
            throw new IllegalArgumentException("Console ID provided not available");
        }
        serviceLayer.updateConsole(consoleViewModel);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> consoleViewModelList = serviceLayer.findConsolebyManufacturer(manufacturer);
        if (consoleViewModelList != null && consoleViewModelList.size() == 0)
            throw new IllegalArgumentException("Game is not available for " + manufacturer);
        return consoleViewModelList;
    }

}
