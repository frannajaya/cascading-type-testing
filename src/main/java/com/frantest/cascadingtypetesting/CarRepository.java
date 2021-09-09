package com.frantest.cascadingtypetesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car getCarBySeries(String series);
}
