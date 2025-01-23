package com.restorant.api.Model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Restorant")
public class Sipariş {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="garson_isim",nullable = false,length = 40)
    private String garsonisim;
    @Column(name ="masa_no")
    private int masaNo;
    @Column(name="s_zaman")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date szaman;

    public Sipariş() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMasaNo() {
        return masaNo;
    }
    public void setMasaNo(int masaNo) {
        this.masaNo = masaNo;
    }
    public String getGarsonisim() {
        return garsonisim;
    }

    public void setGarsonisim(String garsonisim) {
        this.garsonisim = garsonisim;
    }

    public Date getSzaman() {
        return szaman;
    }

    public void setSzaman(Date szaman) {
        this.szaman = szaman;
    }

    public Sipariş(Integer id, String garsonisim, Date szaman,Integer masaNo) {
        this.id = id;
        this.garsonisim = garsonisim;
        this.szaman = szaman;
        this.masaNo = masaNo;
    }
}