package com.onlineCarpetSales.backend.controller;


import com.onlineCarpetSales.backend.entity.CarpetCollections;
import com.onlineCarpetSales.backend.service.CarpetCollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CarpetCollectionsController {

    private CarpetCollectionsService carpetCollectionsService;

    @Autowired
    public CarpetCollectionsController(CarpetCollectionsService carpetCollectionsService) {
        this.carpetCollectionsService = carpetCollectionsService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<CarpetCollections> getAll(){
        List<CarpetCollections> allList = carpetCollectionsService.findAll();
        return allList;
    }
}
