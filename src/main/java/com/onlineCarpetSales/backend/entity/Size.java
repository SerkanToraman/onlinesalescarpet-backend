package com.onlineCarpetSales.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="size", schema="onlinecarpetsales")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="width")
    private int width;
    @Column(name="size")
    private int size;
    @Column(name="is_available")
    private boolean isAvailable;

}
