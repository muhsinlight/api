package com.restorant.api.Controller;

import com.restorant.api.Model.Food;
import com.restorant.api.Service.FoodService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("rest/api/food/")
public class FoodController {
    private final FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    @PostMapping("save")
    public Food createSave(@RequestBody Food food) {
        return foodService.createFood(food);
    }
    @GetMapping("{id}")
    public Food findById(@PathVariable Integer id) {
        return foodService.findById(id);
    }
    @GetMapping("list")
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }
    @DeleteMapping("d/{id}")
    public void deleteFood(@PathVariable Integer id) {
        foodService.deleteFoodById(id);
    }
    @PutMapping("u/{id}")
    public Food updateFood(@PathVariable Integer id, @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }
    @GetMapping("name/{name}")
    public List<Food> findByName(@PathVariable String name) {
        return foodService.findByName(name);
    }
    @GetMapping("category/{category}")
    public List<Food> findByCategory(@PathVariable String category) {
        return foodService.findByCategory(category);
    }
}