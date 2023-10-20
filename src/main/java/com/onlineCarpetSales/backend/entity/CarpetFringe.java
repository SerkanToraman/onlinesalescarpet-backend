package com.onlineCarpetSales.backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="carpetfringe", schema="onlinecarpetsales")
public class CarpetFringe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="is_available")
    private boolean isAvailable;
}
