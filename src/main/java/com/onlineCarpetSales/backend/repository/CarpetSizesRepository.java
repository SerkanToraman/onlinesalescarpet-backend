package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.entity.CarpetSizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarpetSizesRepository extends JpaRepository<CarpetSizes, Integer> {

    @Query("SELECT c FROM CarpetSizes c WHERE carpet.id = :id")
    Optional<List<CarpetSizes>> findAllByCarpetId(@Param("id") int id);

}
