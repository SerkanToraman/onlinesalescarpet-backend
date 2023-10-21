package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Fringe;
import com.onlineCarpetSales.backend.repository.FringeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FringeServiceImp implements FringeService{

    private FringeRepository fringeRepository;

    @Autowired
    public FringeServiceImp(FringeRepository fringeRepository) {
        this.fringeRepository = fringeRepository;
    }

    @Override
    public List<Fringe> findAll() {
        return fringeRepository.findAll();
    }

    @Override
    public Fringe getById(int id) {
        return fringeRepository.getById(id);
    }
}
