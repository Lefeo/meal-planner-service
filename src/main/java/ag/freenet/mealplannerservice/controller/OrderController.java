package ag.freenet.mealplannerservice.controller;

import ag.freenet.mealplannerservice.model.Order;
import ag.freenet.mealplannerservice.service.MealPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/essen")
public class OrderController {

    @Autowired
    private MealPlannerService mealPlannerService;

    @PostMapping("/order/place")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = mealPlannerService.placeOrder(order);
        return ResponseEntity.ok(placedOrder);
    }
}
