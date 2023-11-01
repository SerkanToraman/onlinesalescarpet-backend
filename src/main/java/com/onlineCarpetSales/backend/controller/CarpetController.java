package com.onlineCarpetSales.backend.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineCarpetSales.backend.dto.CarpetDownloadResponse;
import com.onlineCarpetSales.backend.dto.CarpetSizeDownloadResponse;
import com.onlineCarpetSales.backend.dto.CarpetUploadRequest;
import com.onlineCarpetSales.backend.dto.CarpetSizeRequest;
import com.onlineCarpetSales.backend.entity.*;
import com.onlineCarpetSales.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carpets")
public class CarpetController {

    private CarpetService carpetService;
    private CarpetCollectionsService carpetCollectionsService;
    private CarpetSizesService carpetSizesService;
    private SizeService sizeService;

    private FringeService fringeService;

    @Autowired
    public CarpetController(CarpetService carpetService, CarpetCollectionsService carpetCollectionsService, CarpetSizesService carpetSizesService, SizeService sizeService, FringeService fringeService) {
        this.carpetService = carpetService;
        this.carpetCollectionsService = carpetCollectionsService;
        this.carpetSizesService = carpetSizesService;
        this.sizeService = sizeService;
        this.fringeService = fringeService;
    }




    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload")
    public void uploadCarpetWithImage(@RequestPart("imageFile") MultipartFile imageFile, @RequestPart("carpetUploadRequest") CarpetUploadRequest carpetUploadRequest) throws IOException {
        carpetService.uploadImage(imageFile, carpetUploadRequest.getCarpetName());
        Carpet carpet = new Carpet();
        carpet.setCarpetName(carpetUploadRequest.getCarpetName().toUpperCase());
        carpet.setSquaremetrePrice(carpetUploadRequest.getSquaremetrePrice());
        carpet.setDateAdded(LocalDateTime.now());
        carpet.setImagePath(carpetUploadRequest.getCarpetName() + ".png");
        CarpetCollections selectedCollection = carpetCollectionsService.findById(carpetUploadRequest.getCollection_id());
        carpet.setCarpetCollections(selectedCollection);
        List<Integer> carpetFringeIds = carpetUploadRequest.getCarpetFringeList();
        Set<Fringe> carpetFringes = new HashSet<>();
        for (Integer fringeId : carpetFringeIds) {
            Fringe fringe = fringeService.getById(fringeId);
            carpetFringes.add(fringe);
        }
        carpet.setCarpetFringeList(carpetFringes);
        carpetService.saveCarpet(carpet);
        for (CarpetSizeRequest sizeRequest : carpetUploadRequest.getCarpetSizes()) {
            CarpetSizes carpetSize = new CarpetSizes();
            carpetSize.setAvailable(sizeRequest.isAvailable());
            carpetSize.setCarpet(carpet);
            Size size = sizeService.getById(sizeRequest.getSizeId());
            carpetSize.setSize(size);
            carpetSize.setCarpet(carpet);
            carpetSizesService.save(carpetSize);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/downloadImage/{id}")
    public ResponseEntity<byte[]> getCarpetImage(@PathVariable int id) {
        try {
            byte[] imageData = carpetService.downloadImage(id);
            if (imageData.length > 0) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageData);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/download/{name}")
    public CarpetDownloadResponse getCarpetData(@PathVariable String name) {
       Carpet carpet= carpetService.findByName(name.toUpperCase());
       List<CarpetSizes> carpetSizesList=carpetSizesService.findAllByCarpetId(carpet.getId());
//       List<CarpetSizeDownloadResponse> carpetSizeDownloadResponseList = new ArrayList<>();
//        for (CarpetSizes carpetSize : carpetSizesList) {
//            int width = carpetSize.getSize().getWidth();
//            int length = carpetSize.getSize().getLength();
//            boolean available = carpetSize.isAvailable();
//            CarpetSizeDownloadResponse carpetSizeDownloadResponse = new CarpetSizeDownloadResponse(width, length, available);
//            carpetSizeDownloadResponseList.add(carpetSizeDownloadResponse);
//        }

        List<CarpetSizeDownloadResponse> carpetSizeDownloadResponseList = carpetSizesList.stream()
                .map(carpetSize -> new CarpetSizeDownloadResponse(carpetSize.getSize().getWidth(), carpetSize.getSize().getLength(), carpetSize.isAvailable()))
                .sorted(Comparator.comparingInt(CarpetSizeDownloadResponse::width))
                .collect(Collectors.toList());
        Set<Fringe> carpetFringeList = carpet.getCarpetFringeList();
        CarpetDownloadResponse carpetDownloadResponse = new CarpetDownloadResponse(carpet.getId(),carpet.getCarpetName(),carpet.getSquaremetrePrice(),carpetSizeDownloadResponseList,carpetFringeList);
        return carpetDownloadResponse;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/collectionscarpet/{id}")
    public List<Carpet> getCarpetDataByCollection(@PathVariable int id) {
        return carpetService.findAllByCollectionId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Carpet getCarpet(@PathVariable int id) {
        return carpetService.getCarpetById(id);
    }
}





