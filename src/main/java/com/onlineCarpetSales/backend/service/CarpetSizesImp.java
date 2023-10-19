package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.entity.CarpetSizes;
import com.onlineCarpetSales.backend.repository.CarpetSizesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class CarpetSizesImp implements CarpetSizesService {



    private CarpetSizesRepository carpetSizesRepository;

    @Autowired
    public CarpetSizesImp(CarpetSizesRepository carpetSizesRepository) {
        this.carpetSizesRepository = carpetSizesRepository;
    }

    @Override
    public List<CarpetSizes> findAll() {
        return carpetSizesRepository.findAll();
    }

    @Override
    public CarpetSizes save(CarpetSizes carpetSizes) {
        return carpetSizesRepository.save(carpetSizes);
    }

    @Override
    public List<CarpetSizes> findAllByCarpetId(int id) {
        Optional<List<CarpetSizes>> optionalCarpetSizesList = carpetSizesRepository.findAllByCarpetId(id);
        return optionalCarpetSizesList.orElse(null);
    }

}
