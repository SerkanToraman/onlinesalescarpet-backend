package com.onlineCarpetSales.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="collections", schema="onlinecarpetsales")
public class CarpetCollections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="collection_type")
    private String collectionType;

//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            mappedBy = "carpetCollections")
//    private List<Carpet> Carpets;

}
