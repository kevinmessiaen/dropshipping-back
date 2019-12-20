package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.DeliveryInformationDto;
import com.messiaen.dropshipping.model.OrderDto;
import com.messiaen.dropshipping.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OrderController {

    private IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/restricted/order")
    private ResponseEntity<OrderDto> createOrder(@RequestBody DeliveryInformationDto info, Principal principal) {
        return ResponseEntity.of(orderService.createOrder(info, principal));
    }
}
