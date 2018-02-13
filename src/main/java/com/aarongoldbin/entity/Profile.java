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

    private int weight;
    private String height;
    private int age;
    private String sex;
    private String goal;

    @Column(name = "searching_for")
    private int searching;

    @OneToOne
    private int id;

    /**
     * Instantiates a new Profile.
     */
    public Profile() {
    }

    /**
     * Instantiates a new Profile.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param weight    the weight
     * @param height    the height
     * @param age       the age
     * @param sex       the sex
     * @param goal      the goal
     * @param searching the searching
     * @param id        the id
     */
    public Profile(String firstName, String lastName, int weight, String height, int age, String sex, String goal, int searching, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.goal = goal;
        this.searching = searching;
        this.id = id;
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
     * Gets height.
     *
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
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
     * Gets goal.
     *
     * @return the goal
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Sets goal.
     *
     * @param goal the goal
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }

    /**
     * Gets searching.
     *
     * @return the searching
     */
    public int getSearching() {
        return searching;
    }

    /**
     * Sets searching.
     *
     * @param searching the searching
     */
    public void setSearching(int searching) {
        this.searching = searching;
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
}
