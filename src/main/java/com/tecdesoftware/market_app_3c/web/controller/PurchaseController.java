package com.tecdesoftware.market_app_3c.web.controller;

import com.tecdesoftware.market_app_3c.domain.Purchase;
import com.tecdesoftware.market_app_3c.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){ //maneja el tipo de respuesta
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases,HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
