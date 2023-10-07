package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.CarpetCollections;
import com.onlineCarpetSales.backend.repository.CarpetCollectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarpetCollectionsServiceImp implements CarpetCollectionsService {
   private CarpetCollectionsRepository carpetCollectionsRepository;
    @Autowired
    public CarpetCollectionsServiceImp(CarpetCollectionsRepository carpetCollectionsRepository) {
        this.carpetCollectionsRepository = carpetCollectionsRepository;
    }
    @Override
    public List<CarpetCollections> findAll() {
        return this.carpetCollectionsRepository.findAll();
    }

    @Override
    public CarpetCollections findById(int id) {
        Optional<CarpetCollections> existCollection = carpetCollectionsRepository.findById(id);
        if(existCollection.isPresent()){
            return existCollection.get();
        }
        return null;
    }
}
