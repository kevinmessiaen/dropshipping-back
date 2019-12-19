package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.ShippingMethodDto;

import java.util.Collection;

public interface IShippingMethodService {

    Collection<ShippingMethodDto> findAvailableShippingMethods(String uuid);

}
