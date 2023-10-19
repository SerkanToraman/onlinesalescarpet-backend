package com.onlineCarpetSales.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarpetSizeRequest {
    private int sizeId;
    private boolean available;
}
