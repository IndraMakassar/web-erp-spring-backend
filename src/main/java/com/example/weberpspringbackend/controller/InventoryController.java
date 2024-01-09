package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Inventory;
import com.example.weberpspringbackend.model.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public ResponseEntity<Iterable<Inventory>> getAllInventory() {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        if (!inventories.iterator().hasNext()) {
            return new ResponseEntity<>(inventories, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}