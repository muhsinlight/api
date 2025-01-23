package com.restorant.api.Service;

import com.restorant.api.Model.Sipariş;
import com.restorant.api.Repository.RestorantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestorantServiceImpl implements IRestaurantService {
    private final RestorantRepository restaurantRepository;

    public RestorantServiceImpl(RestorantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Sipariş saveSiparis(Sipariş siparis) {
        return restaurantRepository.save(siparis);
    }

    @Override
    public List<Sipariş> getAllSiparis() {
        return restaurantRepository.findAll();
    }

    @Override
    public Sipariş getSiparisById(Integer id) {
        Optional<Sipariş> optional = restaurantRepository.findById(id);
        return optional.orElse(null); // Daha temiz bir kullanım
    }

    @Override
    public void deleteSiparis(Integer id) {
        Sipariş dbSipariş = getSiparisById(id);
        if (dbSipariş != null) {
            restaurantRepository.delete(dbSipariş);
        }
    }

    @Override
    public Sipariş updateSiparis(Integer id, Sipariş updateSipariş) {
        Sipariş dbSipariş = getSiparisById(id);
        if (dbSipariş != null) {
            dbSipariş.setGarsonisim(updateSipariş.getGarsonisim());
            dbSipariş.setSzaman(updateSipariş.getSzaman());
            return restaurantRepository.save(dbSipariş);
        }
        return null;
    }

    @Override
    public Optional<Sipariş> findByMasaNo(int masaNo) {
        return restaurantRepository.findByMasaNo(masaNo);
    }

    @Override
    public Optional<Sipariş> findByGarsonIsim(String garsonIsim) {
        return restaurantRepository.findByGarsonIsim(garsonIsim);
    }
}
