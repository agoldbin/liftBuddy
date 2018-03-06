package com.aarongoldbin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a user
 *
 * @author agoldbin
 */
@Entity(name = "User")
@Table(name = "user") // case senstitive
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String userEmail;

    @ManyToOne
    private Gym gym;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // TODO properly map this. If not transient, tests will fail currently
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Weight> weights = new ArrayList<>();

    private String location;
    //    TODO is password needed to be stored? How to store a password hash
    private String password;
    private String height;
    private LocalDate dob;
    private String sex;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User WITHOUT weight.
     * @param userEmail    the user email
     * @param password     the password
     * @param userName     the user name
     * @param firstName    the first name
     * @param lastName     the last name
     * @param gym          the gym
     * @param location     the user location
     * @param dob          the dob
     * @param height       the height
     * @param sex          the sex
     */
    public User(String userEmail, String password, String userName, String firstName, String lastName
            , Gym gym, String location, LocalDate dob, String height, String sex) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gym = gym;
        this.location = location;
        this.dob = dob;
        this.height = height;
        this.sex = sex;
    }


    /**
     * Instantiates a new User WITH their weight.
     * @param userEmail    the user email
     * @param password     the password
     * @param userName     the user name
     * @param firstName    the first name
     * @param lastName     the last name
     * @param gym          the gym
     * @param location     the user location
     * @param dob          the dob
     * @param height       the height
     * @param weight       the user weight
     * @param sex          the sex
     */
    public User(String userEmail, String password, String userName, String firstName, String lastName
            , Gym gym, String location, LocalDate dob, String height, Weight weight, String sex) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gym = gym;
        this.location = location;
        this.dob = dob;
        this.height = height;
        addWeight(weight);
        this.sex = sex;
    }


    public List<Weight> getWeights(){
        return weights;
    }

    /**
     * Sets users
     *
     * @param weights the users' weight history
     */
    public void setWeights(List<Weight> weights){
        this.weights = weights;
    }

    /**
     * Add user weight.
     *
     * @param weight the user's weight
     */
    public void addWeight(Weight weight) {
        weights.add(weight);
        weight.setUser(this);
    }

    public void removeWeight(Weight weight) {
        weights.remove(weight);
        weight.setUser(null);
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = Period.between(getDob(), now);

        return period.getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", gym=" + gym +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
//                ", userWeight=" + userWeight +
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                '}';
    }



//    // TODO mess with this method and get new weight created for user
//    /**
//     * Add user weight.
//     *
//     * @param weight weight of the user
//     */
//    public void addUserWeight(Weight weight) {
//        weights.add(weight);
//        weight.setWeight(this.weight);
//    }
//
//    /**
//     * Sets user weights
//     *
//     * @param weights the users
//     */
//    public void setWeights(Set<Weight> weights){
//        this.weights = weights;
//    }


//
//    /**
//     * Gets id.
//     *
//     * @return the id
//     */
//    public int getId() {
//        return id;
//    }
//
//    /**
//     * Sets id.
//     *
//     * @param id the id
//     */
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    /**
//     * Gets user name.
//     *
//     * @return the user name
//     */
//    public String getUserName() {
//        return userName;
//    }
//
//    /**
//     * Sets user name.
//     *
//     * @param userName the user name
//     */
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    /**
//     * Gets user email.
//     *
//     * @return the user email
//     */
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    /**
//     * Sets user email.
//     *
//     * @param userEmail the user email
//     */
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    /**
//     * Gets gym.
//     *
//     * @return the gym
//     */
//    public Gym getGym() {
//        return gym;
//    }
//
//    /**
//     * Sets gym.
//     *
//     * @param gym the gym
//     */
//    public void setGym(Gym gym) {
//        this.gym = gym;
//    }
//
//    public String getGymName() {
//        return gym.getGymName();
//    }
//
//    /**
//     * Gets user location.
//     *
//     * @return the user location
//     */
//    public String getLocation() {
//        return location;
//    }
//
//    /**
//     * Sets user location.
//     *
//     * @param location the user location
//     */
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    /**
//     * Gets password.
//     *
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Sets password.
//     *
//     * @param password the password
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * Gets first name.
//     *
//     * @return the first name
//     */
//    public String getFirstName() {
//        return firstName;
//    }
//
//    /**
//     * Sets first name.
//     *
//     * @param firstName the first name
//     */
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    /**
//     * Gets last name.
//     *
//     * @return the last name
//     */
//    public String getLastName() {
//        return lastName;
//    }
//
//    /**
//     * Sets last name.
//     *
//     * @param lastName the last name
//     */
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    /**
//     * Gets height.
//     *
//     * @return the height
//     */
//    public String getHeight() {
//        return height;
//    }
//
//    /**
//     * Sets height.
//     *
//     * @param height the height
//     */
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    /**
//     * Gets sex.
//     *
//     * @return the sex
//     */
//    public String getSex() {
//        return sex;
//    }
//
//    /**
//     * Sets sex.
//     *
//     * @param sex the sex
//     */
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    /**
//     * Gets dob.
//     *
//     * @return the dob
//     */
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    /**
//     * Sets dob.
//     *
//     * @param dob the dob
//     */
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }
//
}