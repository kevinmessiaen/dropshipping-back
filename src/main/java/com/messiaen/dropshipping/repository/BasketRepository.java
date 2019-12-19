package com.messiaen.dropshipping.repository;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.repository.wrapper.BasketWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BasketRepository extends JpaRepository<Basket, UUID> {

    @Query("SELECT new com.messiaen.dropshipping.repository.wrapper.BasketWrapper(b,  sum(c.amount), sum(c.amount * c.id.product.price))" +
            " FROM Basket b join BasketContent c on b.id = c.id.basket.id WHERE b.id = :id")
    Optional<BasketWrapper> fetchById(UUID id);

}
