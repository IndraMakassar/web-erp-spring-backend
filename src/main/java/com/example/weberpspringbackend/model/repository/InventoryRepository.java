package com.example.weberpspringbackend.model.repository;

import com.example.weberpspringbackend.model.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
