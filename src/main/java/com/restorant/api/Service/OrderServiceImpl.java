package com.restorant.api.Service;

import com.restorant.api.Model.Food;
import com.restorant.api.Model.Order;
import com.restorant.api.Repository.FoodRepository;
import com.restorant.api.Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }
    @Override
    public Order saveOrder(Order order) {
        List<Food> managedFoods = new ArrayList<>();

        for (Food food : order.getFoods()) {
            Food dbFood = foodRepository.findById(food.getId())
                    .orElseThrow(() -> new RuntimeException("Food with id " + food.getId() + " not found"));
            managedFoods.add(dbFood);
        }

        order.setFoods(managedFoods);
        return orderRepository.save(order);
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order  getOrderById(Long id) {
        Optional<Order > optional = orderRepository.findById(id);
        return optional.orElse(null);
    }
    @Override
    public void deleteOrder(Long id) {
        Order  dbOrder = getOrderById(id);
        if (dbOrder  != null) {
            orderRepository.delete(dbOrder);
        }
    }
    @Override
    public Order updateOrder(Long id, Order  updateSipariş) {
        Order dbSipariş = getOrderById(id);
        if (dbSipariş != null) {
            dbSipariş.setWaiterName(updateSipariş.getWaiterName());
            dbSipariş.setOrderTime(updateSipariş.getOrderTime());
            return orderRepository.save(dbSipariş);
        }
        return null;
    }
    @Override
    public Optional<Order >findByTableNo(int tableNo){
        return orderRepository.findByTableNo(tableNo);
    }
    @Override
    public Optional<Order> findByWaiterName(String waiterName) {
        return orderRepository.findByWaiterName(waiterName);
    }
}
