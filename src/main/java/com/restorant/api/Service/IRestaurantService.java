package com.restorant.api.Service;

import com.restorant.api.Model.Sipariş;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public interface IRestaurantService {
    public Sipariş saveSiparis(Sipariş siparis);
    public List<Sipariş> getAllSiparis();
    public Sipariş getSiparisById(Integer id);
    public void deleteSiparis(Integer id);
    public Sipariş updateSiparis(Integer id, Sipariş updatesiparis);
    Optional<Sipariş> findByMasaNo(int masaNo);
    Optional<Sipariş> findByGarsonIsim(String garsonIsim);
}