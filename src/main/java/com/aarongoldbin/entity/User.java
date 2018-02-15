package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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
    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String userEmail;

    //   TODO Check how to pull gym name from gym table or if it is unneeded in this class
    @ManyToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "GYM_ID_FK"))
    private Gym gym;

    //    TODO Decide if location will be zip, city or both
    @Column(name = "location")
    private String userLocation;

    //    TODO is password needed to be stored? How to store a password hash
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private int height;

    @Column
    private int weight;

    @Column
    private String sex;

    @Column
    private LocalDate dob;

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
     * @param gym          the gym
     * @param userLocation the user location
     * @param password     the password
     * @param firstName    the first name
     * @param lastName     the last name
     * @param height       the height
     * @param weight       the weight
     * @param sex          the sex
     * @param dob          the dob
     */
    public User(String userName, String userEmail, Gym gym, String userLocation, String password, String firstName,
                String lastName, int height, int weight, String sex, LocalDate dob) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.gym = gym;
        this.userLocation = userLocation;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", gym=" + gym +
                ", userLocation='" + userLocation + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                '}';
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
     * Gets gym.
     *
     * @return the gym
     */
    public Gym getGym() {
        return gym;
    }

    /**
     * Sets gym.
     *
     * @param gym the gym
     */
    public void setGym(Gym gym) {
        this.gym = gym;
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

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets dob.
     *
     * @return the dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Sets dob.
     *
     * @param dob the dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}