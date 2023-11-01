package com.onlineCarpetSales.backend.dto;

import com.onlineCarpetSales.backend.entity.CarpetSizes;
import com.onlineCarpetSales.backend.entity.Fringe;

import java.util.List;
import java.util.Set;

public record CarpetDownloadResponse (int id, String carpetName,int squareMetrePrice, List<CarpetSizeDownloadResponse> carpetSizesList, Set<Fringe> carpetFringeList) {
}
