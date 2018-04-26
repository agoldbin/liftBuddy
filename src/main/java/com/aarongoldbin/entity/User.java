package com.aarongoldbin.entity;

import com.aarongoldbin.persistence.GenericDao;
import com.aarongoldbin.entity.Role;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class to represent a user
 *
 * @author agoldbin
 */
@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
public class User {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Weight> weights = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Workout> workouts = new ArrayList<>();

    //    @Transient
    // TODO properly connect role and user tables
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
//    @ManyToOne
//    private Set<Role> roles = new HashSet<>();


    private String location;
    //    TODO if time permits, store password as hash
    private String password;
    private String height;
    private LocalDate dob;
    private String sex;

    // Cheating to get the gym name of the users gym
    @Transient
    private String gymName;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User WITHOUT height, weight or sex. Defaults user role to buddy
     *
     * @param userEmail    the user email
     * @param password     the password
     * @param userName     the user name
     * @param firstName    the first name
     * @param lastName     the last name
     * @param gym          the gym
     * @param location     the user location
     */
    public User(String userEmail, String password, String userName, String firstName, String lastName
            , Gym gym, String location) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gym = gym;
        this.location = location;
        defaultRole(userName);
    }


    /**
     * Instantiates a new User WITHOUT weight.
     *
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
        defaultRole(userName);
    }

    /**
     * Instantiates a new User WITH their weight.
     *
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
        defaultRole(userName);
    }


    /**
     * Getter for gym name
     *
     * @return name of the gym
     */
    public String getGymName() {
        return gym.getGymName();
    }

    /**
     * Gets the users weights
     *
     * @return the users weights
     */
    public List<Weight> getWeights(){
        return weights;
    }

    /**
     * Sets users Weights
     *
     * @param weights the users weight history
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

    /**
     * Remove user weight
     *
     * @param weight
     */
    public void removeWeight(Weight weight) {
        weights.remove(weight);
        weight.setUser(null);
    }

    // TODO currently not being used
    /**
     * Gets users workouts
     *
     * @return the user's workouts
     */
    public List<Workout> getWorkouts(){
        return workouts;
    }

    /**
     * Sets users Workouts
     *
     * @param workouts the users workout history
     */
    public void setWorkouts(List<Workout> workouts){
        this.workouts = workouts;
    }

    /**
     * Add user workout
     *
     * @param workout the users workout
     */
    public void addWorkout(Workout workout) {
        workouts.add(workout);
        workout.setUser(this);
    }

    /**
     * Remove user workout
     *
     * @param workout
     */
    public void removeWorkout(Workout workout) {
        workouts.remove(workout);
        workout.setUser(null);
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

    /**
     * Sets user role to buddy
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }

    public void defaultRole(String uName) {
//        Role userRole;
//        GenericDao roleDao = new GenericDao(Role.class);
//        List<User> users = roleDao.getByPropertyEqual(userName, uName);
//        if (users.isEmpty()) {
//            Role role = new Role(this, "buddy");
//            roles.add(role);
//            logger.info(uName + "role added as 'buddy'");
//        } else {
//            logger.info(uName + " already has role");
//        }
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
                ", sex='" + sex + '\'' +
                ", dob=" + dob +
                ", role=" + roles +
                '}';
    }

//    /**
//     * This method will set the user role to a standard user
//     */
//    private void setUserRole() {
//        Role role = new Role(2, "buddy", this);
//
//        UserRole userRole = new UserRole(userName, this, role);
//
//        userRoles.add(userRole);
//        role(this);
//    }

}