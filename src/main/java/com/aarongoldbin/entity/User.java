package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user
 *
 * @author agoldbin
 */
@Entity(name = "User")
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
    private int gymId;

    //    TODO Decide if location will be zip, city or both
    @Column(name = "location")
    private String userLocation;

    //    TODO is password needed to be stored? How to store a password hash
    @Column(name = "password")
    private String password;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName     the user name
     * @param userEmail    the user email
     * @param gymId        the gym id
     * @param userLocation the user location
     * @param password     the password
     */
    public User(String userName, String userEmail, int gymId, String userLocation, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.gymId = gymId;
        this.userLocation = userLocation;
        this.password = password;
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
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets gym id.
     *
     * @return the gym id
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets gym id.
     *
     * @param gymId the gym id
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets user location.
     *
     * @return the user location
     */
    public String getUserLocation() {
        return userLocation;
    }

    /**
     * Sets user location.
     *
     * @param userLocation the user location
     */
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", gymId=" + gymId +
                ", userLocation='" + userLocation + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
