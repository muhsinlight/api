package com.restorant.api.Repository;

import com.restorant.api.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query("SELECT f FROM Food f WHERE f.name = :name")
    List<Food> findByName(String name);
    @Query("SELECT f FROM Food f WHERE f.category = :category")
    List<Food> findByCategory(String category);
}
