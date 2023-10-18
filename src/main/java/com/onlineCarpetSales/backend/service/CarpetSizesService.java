package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.CarpetSizes;


import java.util.List;

public interface CarpetSizesService {

    List<CarpetSizes> findAll();
    CarpetSizes save(CarpetSizes carpetSizes);
}
