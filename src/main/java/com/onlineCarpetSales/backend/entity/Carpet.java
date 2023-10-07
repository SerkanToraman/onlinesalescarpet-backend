package com.onlineCarpetSales.backend.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="carpet", schema="onlinecarpetsales")

public class Carpet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="carpet_name")
    private String carpetName;
    @Column(name="squaremetre_price")
    private int squaremetrePrice;

    @Column(name="image_file", columnDefinition = "bytea")
    private byte[] imageFile;
    @Column(name="date_added")
    private LocalDateTime dateAdded;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "collection_id")
//    private CarpetCollections carpetCollections;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "carpet_size", schema ="onlinecarpetsales",
//            joinColumns = {@JoinColumn(name="carpet_id")},
//            inverseJoinColumns = {@JoinColumn(name = "size_id")})
//    private Set<Size> sizes =new HashSet<>();
//    I dont add ManytoMany relation on sizes since i dont need the list of carpets one each size.
//    But above i will see the size available under each carpet



}
