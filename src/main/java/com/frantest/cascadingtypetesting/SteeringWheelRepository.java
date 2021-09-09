package com.frantest.cascadingtypetesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteeringWheelRepository extends JpaRepository<SteeringWheel, Long> {
    SteeringWheel getSteeringWheelByDiameters(double diameters);
}
