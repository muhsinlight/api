package com.restorant.api.Repository;

import com.restorant.api.Model.Sipariş;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestorantRepository extends JpaRepository<Sipariş, Integer> {
    @Query("SELECT s FROM Sipariş s WHERE s.masaNo = :masaNo")
    Optional<Sipariş> findByMasaNo(int masaNo);
    @Query("SELECT s From Sipariş  s Where s.garsonisim = :garsonisim")
    Optional<Sipariş> findByGarsonIsim(String garsonisim);

}
