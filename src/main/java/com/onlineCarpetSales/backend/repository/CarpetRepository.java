package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.dto.CarpetDownloadResponse;
import com.onlineCarpetSales.backend.entity.Carpet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarpetRepository extends JpaRepository<Carpet, Integer> {

}

