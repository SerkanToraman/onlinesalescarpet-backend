package com.onlineCarpetSales.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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
    @Column(name="image_path")
    private String imagePath;
    @Column(name="date_added")
    private LocalDateTime dateAdded;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "collection_id",referencedColumnName = "id")
    private CarpetCollections carpetCollections;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "carpet")
    @JsonIgnore
    private Set<CarpetSizes> carpetSizesList = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name ="carpetfringe",schema="onlinecarpetsales",
            joinColumns = @JoinColumn(name="carpet_id"),
            inverseJoinColumns = @JoinColumn(name="fringe_id"))
    private Set<Fringe> carpetFringeList = new HashSet<>();

    public void addFringe (Fringe fringe){
        if(carpetFringeList==null){
            carpetFringeList = new HashSet<>();
        }
        carpetFringeList.add(fringe);
    }
    public void removeFringe (Fringe fringe){
        if(carpetFringeList==null){
            carpetFringeList = new HashSet<>();
        }
        carpetFringeList.remove(fringe);
    }

}
