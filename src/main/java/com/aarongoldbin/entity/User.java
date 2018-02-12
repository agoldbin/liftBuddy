package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user
 *
 * @author agoldbin
 */
@Entity(name = "liftbuddytest")
@Table(name = "user") // case senstitive

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String userEmail;

//   TODO Check how to pull gym name from gym table or if it is unneeded in this class
    @Column(name = "gym_id")
    private int gym;

//    TODO Decide if location will be zip, city or both
    @Column(name = "location")
    private String userLocation;

//    TODO is password needed to be stored? How to store a password hash
    @Column(name = "password")
    private String password;
}
