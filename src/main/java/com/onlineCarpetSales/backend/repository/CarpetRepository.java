package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.dto.CarpetDownloadResponse;
import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.entity.CarpetSizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarpetRepository extends JpaRepository<Carpet, Integer> {
    @Query("SELECT c FROM Carpet c WHERE c.carpetCollections.id = :id")
    Optional<List<Carpet>> findAllByCollectionId(@Param("id") int id);
    @Query("SELECT c FROM Carpet c WHERE c.carpetName = :name")
    Optional<Carpet> findByName( @Param("name")String name);
}

