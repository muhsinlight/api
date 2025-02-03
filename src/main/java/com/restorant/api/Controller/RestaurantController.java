package com.restorant.api.Controller;
import java.util.List;
import com.restorant.api.Model.Order;
import com.restorant.api.Service.OrderService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/rest/api/res/")
@CrossOrigin(origins = "http://localhost:5173")
public class RestaurantController {
    private final OrderService orderService;
    public RestaurantController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("save")
    public Order  saveSiparis(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    @GetMapping("list")
    public List<Order > getAllOrders() {
        return orderService.getAllOrders();
    }
   @GetMapping("list/{id}")
    public Order  getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @DeleteMapping("delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
    @PutMapping("update/{id}")
    public Order updateOrder (@PathVariable Long id, @RequestBody Order updateOrder) {
        return orderService.updateOrder(id,updateOrder);
    }
    @GetMapping("tableNo/{tableNo}")
    public Order findByTableNo(@PathVariable Integer tableNo) {
        return orderService.findByTableNo(tableNo)
                .orElseThrow(() -> new RuntimeException("Sipariş bulunamadı!"));
    }
    @GetMapping("garsonı/{garsonisim}")
    public Order findByWaiterName(@PathVariable String waiterName) {
        return orderService.findByWaiterName(waiterName).orElseThrow(() -> new RuntimeException("Böyle bir garson yok "));
    }
}
