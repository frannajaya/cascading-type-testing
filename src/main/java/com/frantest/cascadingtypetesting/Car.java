package com.frantest.cascadingtypetesting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity @Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String series;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "steering_wheel_id")
    @Fetch(FetchMode.JOIN)
    private SteeringWheel steeringWheel;
}
