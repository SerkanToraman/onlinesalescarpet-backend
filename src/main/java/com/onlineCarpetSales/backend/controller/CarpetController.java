package com.onlineCarpetSales.backend.controller;

import com.onlineCarpetSales.backend.dto.CarpetDownloadResponse;
import com.onlineCarpetSales.backend.dto.CarpetUploadRequest;
import com.onlineCarpetSales.backend.entity.Carpet;
import com.onlineCarpetSales.backend.entity.CarpetCollections;
import com.onlineCarpetSales.backend.service.CarpetCollectionsService;
import com.onlineCarpetSales.backend.service.CarpetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/carpets")
public class CarpetController {

    private CarpetService carpetService;
    private CarpetCollectionsService carpetCollectionsService;


    @Autowired
    public CarpetController(CarpetService carpetService, CarpetCollectionsService carpetCollectionsService) {
        this.carpetService = carpetService;
        this.carpetCollectionsService = carpetCollectionsService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload")
    public void uploadCarpetWithImage(@ModelAttribute CarpetUploadRequest carpetUploadRequest) throws IOException {
        Carpet carpet = new Carpet();
        carpet.setCarpetName(carpetUploadRequest.getCarpetName());
        carpet.setSquaremetrePrice(carpetUploadRequest.getSquaremetrePrice());
        carpet.setDateAdded(LocalDateTime.now());
        CarpetCollections selectedCollection = carpetCollectionsService.findById(carpetUploadRequest.getCollection_id());
        carpet.setCarpetCollections(selectedCollection);
        carpetService.saveCarpetWithImage(carpet, carpetUploadRequest.getImageFile());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/download/{id}")
    public CarpetDownloadResponse getCarpetImage(@PathVariable int id) {
        Optional<Carpet> carpetOptional = carpetService.getCarpetById(id);
        if (carpetOptional.isPresent()) {
            Carpet carpet = carpetOptional.get();
            String base64Image = Base64.getEncoder().encodeToString(carpet.getImageFile());
            return new CarpetDownloadResponse(carpet.getCarpetName(),base64Image);
        }
        return null;
    }
}
