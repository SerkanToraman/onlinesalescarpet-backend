package com.onlineCarpetSales.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarpetUploadRequest implements Serializable {
    private String carpetName;
    private int squaremetrePrice;
    private MultipartFile imageFile;
}
