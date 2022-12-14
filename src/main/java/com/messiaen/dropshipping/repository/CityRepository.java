package com.messiaen.dropshipping.repository;

import com.messiaen.dropshipping.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT c FROM City c WHERE c.postCodes LIKE CONCAT(:postCode, '%') OR c.postCodes LIKE CONCAT('%-', :postCode, '%') ORDER BY c.name ASC")
    Collection<City> findAllByPostCodeStartingWith(String postCode);

}
