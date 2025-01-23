package com.restorant.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "food")

public class Yemek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

}
