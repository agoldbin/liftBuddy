package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Profile")
@Table(name = "profile") // case senstitive
public class Profile {
    @Column(name = "searching_for")
    private int searching;

    @Id
    @JoinColumn(name = "id")
    public int id;

    private String goal;
    private User user;


    public Profile() {
    }

    public Profile(String goal, int searching, int id) {
        this.goal = goal;
        this.searching = searching;
        this.id = id;
    }
}
