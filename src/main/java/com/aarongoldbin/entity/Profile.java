package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent the profile/personal info of a user
 *
 * @author agoldbin
 */
@Entity(name = "Profile")
@Table(name = "profile") // case senstitive

public class Profile {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "weight")
    private int weight;

    @Column(name = "height")
    private int height;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "goal")
    private String goal;

    @Column(name = "searching_for")
    private int searching;

    @Column(name = "id")
    private int id;

}
