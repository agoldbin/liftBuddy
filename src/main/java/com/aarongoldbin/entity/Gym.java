package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * A class to represent a gym choices
 *
 * @author agoldbin
 */
@Entity(name = "Gym")
@Table(name = "gym") // case senstitive
@Getter
@Setter
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "gym_name")
    private String gymName;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    /**
     * Instantiates a new Gym.
     */
    public Gym() {
    }

    /**
     * Instantiates a new Gym.
     *
     * @param gymName the gym name
     */
    public Gym(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets gym name.
     *
     * @return the gym name
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets gym name.
     *
     * @param gymName the gym name
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets users
     *
     * @returns the users
     */
    public Set<User> getUsers(){
        return users;
    }

    /**
     * Sets users
     *
     * @param users the users
     */
    public void setUsers(Set<User> users){
        this.users = users;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        users.add(user);
        user.setGym(this);
    }

    /**
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) {
        users.remove(user);
        user.setGym(null);
    }
}
