package com.messiaen.dropshipping.repository;

import com.messiaen.dropshipping.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BasketRepository extends JpaRepository<Basket, UUID> {

    Optional<Basket> findByUserUsername(String username);

}
