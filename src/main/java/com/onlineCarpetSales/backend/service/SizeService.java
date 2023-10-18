package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Size;

import java.util.List;

public interface SizeService {
    List<Size> findAll();
    Size getById(int id);
}
