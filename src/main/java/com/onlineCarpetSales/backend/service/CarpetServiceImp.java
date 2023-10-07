package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.repository.CarpetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CarpetServiceImp implements  CarpetService{
    private CarpetRepository carpetRepository;

    @Autowired
    public CarpetServiceImp(CarpetRepository carpetRepository) {
        this.carpetRepository = carpetRepository;
    }

    public void saveCarpetWithImage(Carpet carpet, MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            try {
                System.out.println(Arrays.toString(imageFile.getBytes()));
                carpet.setImageFile(imageFile.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        carpetRepository.save(carpet);
    }

    public Optional<Carpet> getCarpetById(int id) {
        return carpetRepository.findById(id);
    }

}
