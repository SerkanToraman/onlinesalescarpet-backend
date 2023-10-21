package com.onlineCarpetSales.backend.controller;


import com.onlineCarpetSales.backend.entity.Fringe;
import com.onlineCarpetSales.backend.entity.Size;
import com.onlineCarpetSales.backend.service.FringeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fringe")
public class FringeController {
    private FringeService fringeService;
    @Autowired
    public FringeController(FringeService fringeService) {
        this.fringeService = fringeService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<Fringe> getAll(){
        List<Fringe> allList = fringeService.findAll();
        return allList;
    }
}
