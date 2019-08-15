package com.company.PritiSolankiU1Capstone.controller;

import com.company.PritiSolankiU1Capstone.service.ServiceLayer;
import com.company.PritiSolankiU1Capstone.viewmodel.TshirtViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirts")
public class TshirtInventoryController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getAllTShirts() {
        return serviceLayer.findAllTshirts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel createTShirt(@RequestBody TshirtViewModel tShirt) {
        return serviceLayer.saveTshirt(tShirt);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public TshirtViewModel getTShirt(@PathVariable("id") int tShirtsId) {
        TshirtViewModel tshirtViewModel = serviceLayer.findTshirtbyId(tShirtsId);
        if (tshirtViewModel == null)
            throw new IllegalArgumentException("TShirts not available for id " + tShirtsId);
        return tshirtViewModel;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtsId) {
        serviceLayer.removeTshirt(tShirtsId);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int tShirtsId, @RequestBody TshirtViewModel tshirtViewModel) {
        if (tshirtViewModel.gettShirtId() == 0)
            tshirtViewModel.settShirtId(tShirtsId);
        if (tShirtsId != tshirtViewModel.gettShirtId()) {
            throw new IllegalArgumentException("Tshirt ID provided not found");
        }
        serviceLayer.updateTshirt(tshirtViewModel);
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTShirtByColor(@PathVariable("color") String color) {
        List<TshirtViewModel> tshirtViewModelList = serviceLayer.findTshirtbyColor(color);
        if (tshirtViewModelList != null && tshirtViewModelList.size() == 0)
            throw new IllegalArgumentException("TShirts are not available for " + color);
        return tshirtViewModelList;
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTShirtBySize(@PathVariable("size") String size) {
        List<TshirtViewModel> tshirtViewModelList = serviceLayer.findTshirtbySize(size);
        if (tshirtViewModelList != null && tshirtViewModelList.size() == 0)
            throw new IllegalArgumentException("TShirts are not available for " + size);
        return tshirtViewModelList;
    }
}
