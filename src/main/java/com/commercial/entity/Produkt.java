package com.commercial.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "produkt")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produktname", nullable = false, unique = true)
    private String produktName;

    @Column(name = "produktprice", nullable = false)
    private float produktPrice;

    @Column(name = "produktinfo", nullable = false)
    private float produktInfo;

    @Column(name = "produktimg", nullable = false)
    private float produktImg;

    @OneToMany(mappedBy = "produkt", cascade = CascadeType.ALL)
    private List<Bestellung> bestellungen;


}
