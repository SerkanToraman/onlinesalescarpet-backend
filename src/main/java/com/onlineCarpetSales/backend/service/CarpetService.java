package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.dto.CarpetDownloadResponse;
import com.onlineCarpetSales.backend.entity.Carpet;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface CarpetService{
    void saveCarpet(Carpet carpet);

    Carpet getCarpetById(int id);


     void uploadImage(MultipartFile file, String imageName) throws IOException;

    public byte[] downloadImage(int id) throws IOException;




}
