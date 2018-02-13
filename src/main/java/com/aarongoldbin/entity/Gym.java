package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a gym choices
 *
 * @author agoldbin
 */
@Entity(name = "Gym")
@Table(name = "gym") // case senstitive

public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @OneToMany(mappedBy = "gymId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private int id;

    @Column(name = "gym_name")
    private String gymName;
}
