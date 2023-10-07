package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.CarpetCollections;

import java.util.List;

public interface CarpetCollectionsService {
    List<CarpetCollections> findAll();
    CarpetCollections findById(int id);
}
