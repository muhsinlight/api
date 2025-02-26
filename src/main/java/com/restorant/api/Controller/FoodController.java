package com.restorant.api.Controller;

import com.restorant.api.Model.Food;
import com.restorant.api.Response.ApiResponse;
import com.restorant.api.Service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Food>> createSave(@RequestBody Food food) {
        ApiResponse<Food> response = new ApiResponse.Builder<Food>()
                .success(true)
                .message("Food successfully created")
                .data(foodService.createFood(food))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Food>> findById(@PathVariable Integer id) {
        ApiResponse<Food> response = new ApiResponse.Builder<Food>()
                .success(true)
                .message("Food found")
                .data(foodService.findById(id))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<Food>>> getAllFoods() {
        ApiResponse<List<Food>> response = new ApiResponse.Builder<List<Food>>()
                .success(true)
                .message("Food list retrieved successfully")
                .data(foodService.getAllFoods())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("d/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteFood(@PathVariable Integer id) {
        foodService.deleteFoodById(id);
        ApiResponse<Void> response = new ApiResponse.Builder<Void>()
                .success(true)
                .message("Food deleted successfully")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<Food>> updateFood(@PathVariable Integer id, @RequestBody Food food) {
        ApiResponse<Food> response = new ApiResponse.Builder<Food>()
                .success(true)
                .message("Food updated successfully")
                .data(foodService.updateFood(id, food))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<ApiResponse<List<Food>>> findByName(@PathVariable String name) {
        ApiResponse<List<Food>> response = new ApiResponse.Builder<List<Food>>()
                .success(true)
                .message("Foods found by name")
                .data(foodService.findByName(name))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<ApiResponse<List<Food>>> findByCategory(@PathVariable String category) {
        ApiResponse<List<Food>> response = new ApiResponse.Builder<List<Food>>()
                .success(true)
                .message("Foods found by category")
                .data(foodService.findByCategory(category))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
