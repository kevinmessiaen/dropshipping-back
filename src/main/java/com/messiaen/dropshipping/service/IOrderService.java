package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.DeliveryInformationDto;
import com.messiaen.dropshipping.model.OrderDto;

import java.security.Principal;
import java.util.Optional;

public interface IOrderService {

    Optional<OrderDto> createOrder(DeliveryInformationDto info, Principal principal);

}
