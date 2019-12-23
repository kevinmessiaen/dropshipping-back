package com.messiaen.dropshipping.repository;

import com.messiaen.dropshipping.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    @Modifying
    @Query("UPDATE Stock s " +
            "SET s.inBasket = (SELECT COALESCE(SUM(c.amount), 0) FROM BasketContent c WHERE c.id.product.id = s.id AND c.id.basket.lastUpdate > :basketValidity)" +
            "WHERE s.id IN (:products)")
    int updateInStock(Collection<Integer> products, LocalDateTime basketValidity);

}
