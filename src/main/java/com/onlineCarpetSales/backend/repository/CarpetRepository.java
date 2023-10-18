package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.entity.Carpet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarpetRepository extends JpaRepository<Carpet, Integer> {

    @Query("SELECT c FROM Carpet c LEFT JOIN carpetsizes cs WHERE c.carpetName = :carpetName")
    Optional<Carpet> findByCarpetname(String carpetName);
}

