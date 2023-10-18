package com.onlineCarpetSales.backend.controller;


import com.onlineCarpetSales.backend.entity.CarpetCollections;
import com.onlineCarpetSales.backend.entity.Size;
import com.onlineCarpetSales.backend.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/size")
public class SizeController {
    private SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<Size> getAll(){
        List<Size> allList = sizeService.findAll();
        return allList;
    }

}
