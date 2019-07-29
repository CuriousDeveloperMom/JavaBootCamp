package com.company.PritiSolankiU1Capstone.controller;

import com.company.PritiSolankiU1Capstone.service.ServiceLayer;
import com.company.PritiSolankiU1Capstone.viewmodel.InvoiceInputViewModel;
import com.company.PritiSolankiU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping
public class InvoiceInventoryController {

    @Autowired
    ServiceLayer serviceLayer;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody @Valid InvoiceInputViewModel invoice) {
        return serviceLayer.saveInvoice(invoice);
    }

}
