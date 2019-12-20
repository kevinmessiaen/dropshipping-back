package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.DeliveryInformationDto;
import com.messiaen.dropshipping.model.OrderDto;
import com.messiaen.dropshipping.service.IOrderService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Override
    public Optional<OrderDto> createOrder(DeliveryInformationDto info, Principal principal) {
        return Optional.empty();
    }

}
