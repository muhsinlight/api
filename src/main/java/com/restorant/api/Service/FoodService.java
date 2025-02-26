package com.restorant.api.Service;

import com.restorant.api.Model.Food;

import java.util.List;

public interface FoodService {
    Food createFood(Food food);

    Food findById(Integer id);

    List<Food> getAllFoods();

    void deleteFoodById(Integer id);

    Food updateFood(Integer id, Food food);

    List<Food> findByName(String name);

    List<Food> findByCategory(String category);
}
