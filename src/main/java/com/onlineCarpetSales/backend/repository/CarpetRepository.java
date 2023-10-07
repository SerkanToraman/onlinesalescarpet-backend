package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.entity.Carpet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpetRepository extends JpaRepository<Carpet, Integer> {
}

