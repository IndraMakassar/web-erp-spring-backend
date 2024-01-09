package com.example.weberpspringbackend.model.repository;

import com.example.weberpspringbackend.model.entity.Finance;
import org.springframework.data.repository.CrudRepository;

public interface FinanceRepository extends CrudRepository<Finance, Long> {
}
