package com.example.weberpspringbackend.controller;

import com.example.weberpspringbackend.model.entity.Inventory;
import com.example.weberpspringbackend.model.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryRepository inventoryRepository;

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

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventoryById(@PathVariable Long id, @RequestBody Inventory newInventory) {
        if(inventoryRepository.existsById(id)) {
            Inventory oldInventory = inventoryRepository.findById(id).get();
            oldInventory.setJumlah(newInventory.getJumlah());
            inventoryRepository.save(oldInventory);
            return new ResponseEntity<>(oldInventory, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}