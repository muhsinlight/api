package com.restorant.api.Service;

import com.restorant.api.Model.Food;
import com.restorant.api.Repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    @Override
    public Food createFood(Food food) {
       return foodRepository.save(food);
    }

    @Override
    public Food findById(Integer id) {
        return foodRepository.findById(id).orElse(null);
    }
    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public void deleteFoodById(Integer id) {
        Food dbFood = findById(id);
        if (dbFood!= null) {
         foodRepository.delete(dbFood);
        }
    }
    @Override
    public Food updateFood(Integer id,Food food) {
        Food dbFood = foodRepository.findById(food.getId()).orElse(null);
        if (dbFood != null) {
            dbFood.setName(food.getName());
            dbFood.setPrice(food.getPrice());
            foodRepository.save(dbFood);
        }
        return null;
    }
    @Override
    public List<Food> findByName(String name) {
        return foodRepository.findByName(name);
    }
    @Override
    public List<Food> findByCategory(String category) {
        return foodRepository.findByCategory(category);
    }
}
