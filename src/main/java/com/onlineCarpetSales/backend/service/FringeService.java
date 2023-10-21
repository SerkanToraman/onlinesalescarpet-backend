package com.onlineCarpetSales.backend.service;



import com.onlineCarpetSales.backend.entity.Fringe;

import java.util.List;

public interface FringeService {
    List<Fringe> findAll();
    Fringe getById(int id);
}
