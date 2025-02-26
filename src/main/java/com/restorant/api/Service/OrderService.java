package com.restorant.api.Service;

import com.restorant.api.Model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    void deleteOrder(Long id);

    Order updateOrder(Long id, Order updatesiparis);

    Optional<Order> findByTableNo(int masaNo);

    Optional<Order> findByWaiterName(String garsonIsim);

}
