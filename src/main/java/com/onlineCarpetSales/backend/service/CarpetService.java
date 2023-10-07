package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Carpet;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface CarpetService{
    void saveCarpetWithImage(Carpet carpet, MultipartFile imageFile);

    Optional<Carpet> getCarpetById(int id);
}
