package com.onlineCarpetSales.backend.dto;

import com.onlineCarpetSales.backend.entity.CarpetSizes;

import java.util.List;
import java.util.Set;

public record CarpetDownloadResponse (String carpetName, List<CarpetSizeDownloadResponse> CarpetSizesList) {
}
