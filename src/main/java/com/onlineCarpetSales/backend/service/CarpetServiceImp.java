package com.onlineCarpetSales.backend.service;

import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.repository.CarpetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.nio.file.Files;

@Service
public class CarpetServiceImp implements  CarpetService{

    @Value("${upload.path}")
    private String uploadPath;
    private CarpetRepository carpetRepository;

    @Autowired
    public CarpetServiceImp(CarpetRepository carpetRepository) {
        this.carpetRepository = carpetRepository;
    }

    public void saveCarpet(Carpet carpet) {
        carpetRepository.save(carpet);
    }

    public Optional<Carpet> getCarpetById(int id) {
        return carpetRepository.findById(id);
    }

    public void uploadImage(MultipartFile file, String imageName) throws IOException {
        String filePath = uploadPath + imageName + ".png";
        File dest = new File(filePath);
        file.transferTo(dest);
    }


    public byte[] downloadImage(int id) throws IOException {
        Optional<Carpet> carpetData = carpetRepository.findById(id);
        if (carpetData.isEmpty()) {
            return new byte[0];
            //todo exception
        }
        String imagePath=uploadPath+carpetData.get().getImagePath();
        System.out.println(imagePath);
        byte[] images = Files.readAllBytes(new File(imagePath).toPath());
        return images;
    }
}
