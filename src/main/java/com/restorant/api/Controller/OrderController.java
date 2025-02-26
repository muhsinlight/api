package com.restorant.api.Controller;

import com.restorant.api.Model.Order;
import com.restorant.api.Response.ApiResponse;
import com.restorant.api.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/res/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<ApiResponse<Order>> saveOrder(@RequestBody Order order) {
        ApiResponse<Order> response = new ApiResponse.Builder<Order>()
                .success(true)
                .message("Order successfully created")
                .data(orderService.saveOrder(order))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        ApiResponse<List<Order>> response = new ApiResponse.Builder<List<Order>>()
                .success(true)
                .message("Orders retrieved successfully")
                .data(orderService.getAllOrders())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById(@PathVariable Long id) {
        ApiResponse<Order> response = new ApiResponse.Builder<Order>()
                .success(true)
                .message("Order found")
                .data(orderService.getOrderById(id))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        ApiResponse<Void> response = new ApiResponse.Builder<Void>()
                .success(true)
                .message("Order deleted successfully")
                .build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<Order>> updateOrder(@PathVariable Long id, @RequestBody Order updateOrder) {
        ApiResponse<Order> response = new ApiResponse.Builder<Order>()
                .success(true)
                .message("Order updated successfully")
                .data(orderService.updateOrder(id, updateOrder))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("tableNo/{tableNo}")
    public ResponseEntity<ApiResponse<Order>> findByTableNo(@PathVariable Integer tableNo) {
        Order order = orderService.findByTableNo(tableNo)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı!"));

        ApiResponse<Order> response = new ApiResponse.Builder<Order>()
                .success(true)
                .message("Order found by table number")
                .data(order)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("waiter/{waiterName}")
    public ResponseEntity<ApiResponse<Order>> findByWaiterName(@PathVariable String waiterName) {
        Order order = orderService.findByWaiterName(waiterName)
                .orElseThrow(() -> new RuntimeException("Böyle bir garson yok"));

        ApiResponse<Order> response = new ApiResponse.Builder<Order>()
                .success(true)
                .message("Order found by waiter name")
                .data(order)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
