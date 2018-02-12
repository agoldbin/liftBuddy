package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a gym choices
 *
 * @author agoldbin
 */
@Entity(name = "liftbuddytest")
@Table(name = "gym") // case senstitive

public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "gym_id")
    private int gymId;

    @Column(name = "gym_name")
    private String gymName;
}
