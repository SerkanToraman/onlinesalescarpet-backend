package com.onlineCarpetSales.backend.repository;

import com.onlineCarpetSales.backend.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Integer> {
}