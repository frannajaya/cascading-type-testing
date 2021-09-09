package com.frantest.cascadingtypetesting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name = "steering_wheels")
public class SteeringWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double diameters;

    @OneToOne(fetch = FetchType.LAZY, mappedBy="steeringWheel")
    private Car car;
}
