package com.onlineCarpetSales.backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="fringe", schema="onlinecarpetsales")
public class Fringe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fringe_type")
    private String fringeType;
    @Column(name="fringe_price")
    private String fringePrice;

}
