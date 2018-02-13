package com.aarongoldbin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Profile")
@Table(name = "profile") // case senstitive
public class Profile {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "searching_for")
    private int searching;

    @Id
    @JoinColumn(name = "id")
    public int id;

    private int weight;
    private String height;
    private int age;
    private String sex;
    private String goal;
    private User user;


    public Profile() {
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getSearching() {
        return searching;
    }

    public void setSearching(int searching) {
        this.searching = searching;
    }

    public int getUserId() {
        return user.getId();
    }

    public void setId(int id) {
        this.id = id;
    }
}
