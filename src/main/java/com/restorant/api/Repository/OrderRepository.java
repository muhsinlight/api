package com.restorant.api.Repository;

import com.restorant.api.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository  extends JpaRepository<Order, Long> {
    @Query("SELECT s FROM Order  s WHERE s.tableNo = :tableNo")
    Optional<Order> findByTableNo(int tableNo);
    @Query("SELECT s From Order  s Where s.waiterName = :waiterName")
    Optional<Order> findByWaiterName(String waiterName);
}
