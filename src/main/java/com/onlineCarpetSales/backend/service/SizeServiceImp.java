package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Size;
import com.onlineCarpetSales.backend.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SizeServiceImp implements SizeService {
    private SizeRepository sizeRepository;
    @Autowired
    public SizeServiceImp(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }
    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(int id) {
        return sizeRepository.getById(id);
    }
}
