package com.java.orders.controller;

import java.util.List;
import com.java.orders.response.OrderDetailsWithCustomerAndProducts;
import com.java.orders.response.OrderResponse;
import com.java.orders.response.ResponseOfCustomerWithOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.orders.dto.Orderdto;
import com.java.orders.service.IOrderService;

@RestController
@RequestMapping("/orders/api")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService iOrderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody Orderdto orderdto) {
        return ResponseEntity.ok(iOrderService.saveOrder(orderdto));
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody Orderdto orderdto, @PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(iOrderService.updateOrder(orderdto, orderId));
    }

    @GetMapping("/findByOrderId/{orderId}")
    public ResponseEntity<OrderResponse> findOrderById(@PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(iOrderService.findByOrderId(orderId));
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        return ResponseEntity.ok(iOrderService.findAllOrders());
    }

    @GetMapping("/OrderDetailsWithCustomerAndProducts/{orderId}")
    public ResponseEntity<OrderDetailsWithCustomerAndProducts> getOrderDetails(@PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(iOrderService.getOrderDetails(orderId));
    }

    @GetMapping("/ResponseOfCustomerWithOrder/{orderId}")
    public ResponseEntity<ResponseOfCustomerWithOrder> getCustomerDetailsWithOrderId(@PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(iOrderService.getCustomerDetailsWithOrderId(orderId));
    }
}
