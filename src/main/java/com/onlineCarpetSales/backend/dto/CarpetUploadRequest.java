package com.onlineCarpetSales.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarpetUploadRequest implements Serializable {
    private String carpetName;

    private int squaremetrePrice;

    private String imagePath;

    private int collection_id;

    private List<CarpetSizeRequest> carpetSizes;

    private  List<Integer> carpetFringeList;

}


